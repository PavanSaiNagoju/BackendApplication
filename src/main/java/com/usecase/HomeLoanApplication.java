package com.usecase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@ComponentScan(basePackages="com.usecase")
public class HomeLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeLoanApplication.class, args);
		System.out.println("HomeLoanApplication Started on port 8081");
	}

}
