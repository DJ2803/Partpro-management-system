package com.unt.se.ppms.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.unt.se.ppms")
@EntityScan(basePackages = "com.unt.se.ppms.entities")
@EnableJpaRepositories(basePackages = "com.unt.se.ppms.repository")
public class PartpromanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartpromanagementsystemApplication.class, args);
	}

}
