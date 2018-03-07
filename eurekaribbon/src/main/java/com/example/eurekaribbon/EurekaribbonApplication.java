package com.example.eurekaribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker//EnableHystrix 等价
@EnableHystrixDashboard
@SpringBootApplication
public class EurekaribbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaribbonApplication.class, args);
	}
}
