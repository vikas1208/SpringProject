package com.vikas.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer  //this means that to host as web page in url without using GETmapping
@SpringBootApplication
public class SprintCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintCloudConfigApplication.class, args);
	}

}
