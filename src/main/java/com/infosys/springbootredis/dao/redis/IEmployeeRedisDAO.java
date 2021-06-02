package com.infosys.springbootredis.dao.redis;

import com.infosys.springbootredis.data.dto.EmployeeDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRedisDAO extends CrudRepository<EmployeeDTO, Integer> {
}
