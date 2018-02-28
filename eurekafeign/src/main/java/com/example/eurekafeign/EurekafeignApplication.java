package com.example.eurekafeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekafeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekafeignApplication.class, args);
	}
}
