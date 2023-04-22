package com.in28minutes.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	Configuration config;
	
	@GetMapping(value = "/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(config.getMaximum(), config.getMinimum());
	}
}
