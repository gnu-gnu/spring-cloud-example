package com.gnu.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ClientController {
	@Value("${spring.profiles}")
	private String zone;
	
	private RestTemplate restTemplate;
	
	public ClientController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * 
	 * @return Zone name that this instance belongs to.
	 */
	@GetMapping("/ping")
	public String ping() {
		return "This is "+zone;
	}
	
	@GetMapping("/greets")
	public String greets() {
		return restTemplate.getForObject("http://client-service-2/greeting", String.class);
	}
}
