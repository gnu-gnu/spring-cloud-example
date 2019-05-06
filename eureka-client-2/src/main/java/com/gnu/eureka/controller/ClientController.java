package com.gnu.eureka.controller;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClientController {
	@Value("${spring.profiles}")
	private String zone;
	/**
	 * 
	 * @return Zone name that this instance belongs to.
	 */
	@GetMapping("/ping")
	public String ping() {
		return "This is "+zone;
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return Arrays.asList("Hello?", "Nice to meet you!", "Good to see you", "ni hao!").get(new Random().nextInt(4))+" "+zone;
	}
}
