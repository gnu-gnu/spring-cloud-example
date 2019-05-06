package com.gnu.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ClientController {
	private String zone;
	private RestTemplate restTemplate;
	private final String CLIENT_SERVICE_2 = "client-service-2";
	
	public ClientController(RestTemplate restTemplate, @Value("${spring.profiles}") String zone) {
		this.zone = zone;
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
		return restTemplate.getForObject("http://"+CLIENT_SERVICE_2+"/greeting", String.class);
	}
}
