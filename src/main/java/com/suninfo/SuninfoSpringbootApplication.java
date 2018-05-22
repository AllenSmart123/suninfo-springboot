package com.suninfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.suninfo.dao")
public class SuninfoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuninfoSpringbootApplication.class, args);
	}
}
