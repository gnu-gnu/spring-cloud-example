package com.gnu.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@Value("${spring.profiles}")
	private String zone;
	
	@GetMapping("/ping")
	public String ping() {
		return "This is "+zone;
	}
}
