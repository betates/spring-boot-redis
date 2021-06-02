package com.infosys.springbootredis.service;

import com.infosys.springbootredis.converter.EmployeeConverter;
import com.infosys.springbootredis.data.model.Employee;
import com.infosys.springbootredis.dao.entity.IEmployeeDAO;
import com.infosys.springbootredis.data.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDAO employeeDAO;


    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private com.infosys.springbootredis.dao.redis.IEmployeeRedisDAO IEmployeeRedisDAO;

    @Override
    public int insert(Employee employee) {
        employeeDAO.save(employee);
        IEmployeeRedisDAO.save(employeeConverter.convertModelToDTO(employee));
        return 1;
    }

    @Override
    public int update(Employee employee, Integer id) {
        Employee e = employeeDAO.findById(id).get();
        e.setCode(employee.getCode());
        e.setName(employee.getName());
        e.setRemarks(employee.getRemarks());
        e.setStatus(employee.getStatus());
        employeeDAO.save(e);

        EmployeeDTO tempDTO = employeeConverter.convertModelToDTO(e);

        EmployeeDTO employeeDTO = IEmployeeRedisDAO.findById(id).get();
        tempDTO.setId(employeeDTO.getId());
        IEmployeeRedisDAO.save(employeeDTO);
        return 1;
    }

    @Override
    public int delete(Integer id) {
        employeeDAO.deleteById(id);

        IEmployeeRedisDAO.deleteById(id);
        return 1;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public List<EmployeeDTO> findAllRedis() {
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        IEmployeeRedisDAO.findAll().forEach(employeeDTOs::add);
        return employeeDTOs;
    }
}
