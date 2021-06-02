package com.infosys.springbootredis.converter;

import com.infosys.springbootredis.data.dto.EmployeeDTO;
import com.infosys.springbootredis.data.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConverter {

    public Employee convertDTOToModel(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setCode(employeeDTO.getCode());
        employee.setName(employeeDTO.getName());
        employee.setRemarks(employeeDTO.getRemarks());
        employee.setStatus(employeeDTO.getStatus());
        return employee;
    }

    public EmployeeDTO convertModelToDTO(Employee employee) {
        EmployeeDTO result = new EmployeeDTO();
        result.setId(employee.getId());
        result.setCode(employee.getCode());
        result.setName(employee.getName());
        result.setRemarks(employee.getRemarks());
        result.setStatus(employee.getStatus());
        return result;
    }
}
