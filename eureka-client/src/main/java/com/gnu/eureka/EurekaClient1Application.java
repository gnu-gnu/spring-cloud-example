package com.gnu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * Eureka Client 서비스
 * Spring boot 2.1.4 기준, 별도의 어노테이션이나 등록 절차 없이도 Discovery Client 의 의존성을 감지하면
 * 자동으로 Server에 등록한다
 * 
 * @author gnu-gnu(geunwoo.j.shim@gmail.com)
 *
 */
@SpringBootApplication
public class EurekaClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient1Application.class, args);
	}

}
