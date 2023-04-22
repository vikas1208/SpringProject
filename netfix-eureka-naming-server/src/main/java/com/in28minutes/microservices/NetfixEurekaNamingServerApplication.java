package com.in28minutes.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetfixEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetfixEurekaNamingServerApplication.class, args);
	}

}
