package com.infosys.springbootredis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/echo")
public class EchoEndPoint {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
