package com.packsendme.logistic.sheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Microservice_Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice_Application.class, args);
	}
}

