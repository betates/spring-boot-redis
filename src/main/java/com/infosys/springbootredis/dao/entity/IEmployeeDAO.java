package com.infosys.springbootredis.dao.entity;

import com.infosys.springbootredis.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {
}
