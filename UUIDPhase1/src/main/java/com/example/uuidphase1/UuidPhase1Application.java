package com.example.uuidphase1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.uuidphase1")
@EntityScan(basePackages = "com.example.uuidphase1")
public class UuidPhase1Application {

	public static void main(String[] args) {
		//making changes

		SpringApplication.run(UuidPhase1Application.class, args);
	}

}
