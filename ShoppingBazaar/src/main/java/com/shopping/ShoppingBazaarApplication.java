package com.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ShoppingBazaarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingBazaarApplication.class, args);
	}

}
