package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NorisMailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorisMailServiceApplication.class, args);
	}

}
