package com.example.backend;

import com.example.backend.entity.Employee;
import com.example.backend.service.EmployeeService;
import com.example.backend.service.implementation.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

}
