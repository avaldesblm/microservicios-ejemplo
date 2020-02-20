package com.microservices.example.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringbootServiceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceEurekaApplication.class, args);
	}

}
