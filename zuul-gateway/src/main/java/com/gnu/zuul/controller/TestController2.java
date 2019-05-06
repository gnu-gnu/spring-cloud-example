package com.gnu.zuul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Remote Configruration refresh test
 * 
 * <pre>
 * This controller doesn't have @RefreshScope
 * thus, after trigger /actuator/refresh, it won't be changed though sample property is assigned
 * </pre>
 * @author gnu-gnu(geunwoo.j.shim@gmail.com)
 *
 */
@RestController
public class TestController2 {
	@Value("${custom.data.value}") 
	private String value;
	
	@RequestMapping("/get2")
	public String get() {
		return value;
	}
}
