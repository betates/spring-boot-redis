package com.infosys.springbootredis.service;

import com.infosys.springbootredis.data.model.Employee;
import com.infosys.springbootredis.data.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {

    int insert(Employee employee);

    int update(Employee employee, Integer id);

    int delete(Integer id);

    List<Employee> findAll();

    List<EmployeeDTO> findAllRedis();
}
