package com.gnu.eureka.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClientController {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

	
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
	
	@GetMapping("/userList")
	public List<String> getUserList() throws Exception{
		Random r = new Random();
		int chaos = r.nextInt(3);
		LOG.info(String.valueOf(chaos));
		if(chaos % 2 == 0) {
			throw new Exception();
		} else {
			List<String> list = Arrays.asList("Gnu Shim", "Donghwan Noh", "Dalhyun Kim");
			return list;
		}
	}
}
