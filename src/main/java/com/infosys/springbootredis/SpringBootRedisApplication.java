package com.infosys.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableCaching
@EnableRedisRepositories
@SpringBootApplication
public class SpringBootRedisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

	@Autowired private RedisTemplate<String, String> redisTemplate;

	@Override
	public void run(String... args) throws Exception {
		ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
		valueOps.append("KAFKA_1_TEST","1");
	}
}
