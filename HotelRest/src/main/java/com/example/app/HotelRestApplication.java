package com.example.app;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.example.models"})
@EnableJpaRepositories(basePackages = {
		"com.example.repositories"
})
@SpringBootApplication(scanBasePackages = {
		"com.example.data",
		"com.example.exceptions",
		"com.example.controllers"
})
public class HotelRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestApplication.class, args);
	}

}
