package com.gnu.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gnu.eureka.service.ClientService;
import com.gnu.eureka.service.FeignClientService;
@RestController
public class ClientController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

	private String zone;
	private RestTemplate restTemplate;
	private final String CLIENT_SERVICE_2 = "client-service-2";
	private ClientService clientService;
	private final FeignClientService feignClient;
	
	public ClientController(ClientService clientService, RestTemplate restTemplate, @Value("${spring.profiles}") String zone, FeignClientService feignClient) {
		this.clientService = clientService;
		this.zone = zone;
		this.restTemplate = restTemplate;
		this.feignClient = feignClient;
	}

	/**
	 * 
	 * @return Zone name that this instance belongs to.
	 */
	@GetMapping("/ping")
	public String ping() {
		LOG.info(zone);
		return "This is "+zone;
	}
	
	@GetMapping("/greets")
	public String greets() {
		LOG.info(zone);
		return restTemplate.getForObject("http://"+CLIENT_SERVICE_2+"/greeting", String.class);
	}
	
	@GetMapping("/userList")
	public String userList() {
		LOG.info(zone);
		return clientService.userList();
	}
	
	@GetMapping("/userListByFeign")
	public String userListByFeign() {
		LOG.info(zone);
		return feignClient.userList();
	}
}
