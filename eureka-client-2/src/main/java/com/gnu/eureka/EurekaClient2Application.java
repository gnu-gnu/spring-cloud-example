package com.gnu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**

 * Eureka Client Service
 * <pre>
 * On Spring boot 2.1.4, if project has a discovery-client dependency, 
 * it automatically tries to register discovery server itself. 
 * (no need to @EnableEurekaClient or @EnableDiscoveryClient)
 * </pre>
 * @author gnu-gnu(geunwoo.j.shim@gmail.com)
 * @see https://cloud.spring.io/spring-cloud-netflix/multi/multi__service_discovery_eureka_clients.html
 *
 */
@SpringBootApplication
public class EurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient2Application.class, args);
	}

}
