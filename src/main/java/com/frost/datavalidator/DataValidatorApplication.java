package com.frost.datavalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DataValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataValidatorApplication.class, args);
	}

}
