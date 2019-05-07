package com.gnu.eureka.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ClientService {
	
	private RestTemplate restTemplate;
	private final String CLIENT_SERVICE_2 = "client-service-2";
	public ClientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	/**
	 * 
	 * request with hystrix proxy (fallback and circuit breaker)
	 * 
	 * <pre>
	 * to use @HystrixCommand annnotation, classpath requires 'spring-cloud-starter-netflix-hystrix' dependency
	 * though netflix-eureka-client and ribbon include netflix-hystrix and hystrix-core, this annotation belongs to hystrix-javanica in 'spring-cloud-starter-netflix-hystrix'  
	 * </pre>
	 * @see {@link <a href="https://github.com/Netflix/Hystrix/wiki/Configuration">Configuration</a>} 
	 * @return
	 */
	@HystrixCommand(
			fallbackMethod="userListFallback",
			commandProperties = {
					// if at least, five request sent and more 20% fails, stop for 10000ms (circuit open, it means that automatically triggers fallback for 10seconds)
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5"),
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="20"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000")
			}
			)
	public String userList() {
		return restTemplate.getForObject("http://" + CLIENT_SERVICE_2 + "/userList", String.class);
	}
	/**
	 * 
	 * fallback method for userList()
	 * if client-service-2 causes exception, this method returns error to prevent propagation.
	 * 
	 * @return
	 */
	public String userListFallback() {
		return "error";
	}
}
