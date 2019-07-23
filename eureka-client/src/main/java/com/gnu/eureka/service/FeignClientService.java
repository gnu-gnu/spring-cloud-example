package com.gnu.eureka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gnu.eureka.service.FeignClientService.HystrixClientFallback;

@FeignClient(name = "client-service-2", fallback = HystrixClientFallback.class)
public interface FeignClientService {
	@RequestMapping(method = RequestMethod.GET, value = "/userList", consumes = "application/json")
	String userList();

	static class HystrixClientFallback implements FeignClientService {
		private static final Logger LOG = LoggerFactory.getLogger(HystrixClientFallback.class);

		@Override
		public String userList() {
			LOG.error("fallback!!");
			return "Feign Fallback";
		}

	}
}
