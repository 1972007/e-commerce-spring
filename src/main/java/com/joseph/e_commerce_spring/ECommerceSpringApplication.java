package com.joseph.e_commerce_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ECommerceSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceSpringApplication.class, args);
	}

}
