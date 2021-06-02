package com.infosys.springbootredis.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("employee")
@Getter
@Setter
public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 8831404359805237177L;
    private Integer id;
    private String code;
    private String name;
    private String remarks;
    private Boolean status;
}
