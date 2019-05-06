package com.gnu.zuul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Remote Configruration refresh test
 * 
 * @author gnu-gnu(geunwoo.j.shim@gmail.com)
 *
 */
@RestController
@RefreshScope // when /actuator/refresh triggered, configuration is refreshed in this bean
public class TestController {
	@Value("${custom.data.value}") 
	private String value;
	
	@RequestMapping("/get")
	public String get() {
		return value;
	}
}
