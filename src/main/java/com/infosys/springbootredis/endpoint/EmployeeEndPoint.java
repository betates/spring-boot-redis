package com.infosys.springbootredis.endpoint;

import com.infosys.springbootredis.converter.EmployeeConverter;
import com.infosys.springbootredis.data.model.Employee;
import com.infosys.springbootredis.data.dto.EmployeeDTO;
import com.infosys.springbootredis.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeEndPoint {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    @GetMapping("/findAllDB")
    public List<Employee> findAllDB() {
        return employeeService.findAll();
    }

    @Cacheable(value = "employees")
    @GetMapping("/findAllRedis")
    public List<EmployeeDTO> findAllRedis() {
        List<Employee> employees = employeeService.findAll();
        System.out.println("Call From DB");
        List<EmployeeDTO> em = new ArrayList<>();
        for (Employee employee : employees) {
            em.add(employeeConverter.convertModelToDTO(employee));
        }
        return em;
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.convertDTOToModel(employeeDTO);
        employeeService.insert(employee);
        return 1;
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@RequestParam("id") Integer id) {
        employeeService.delete(id);
        return 1;
    }
}
