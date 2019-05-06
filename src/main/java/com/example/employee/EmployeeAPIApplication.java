package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.example.employee.entity" })
public class EmployeeAPIApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeAPIApplication.class, args);
	}
}
