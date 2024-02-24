package com.verizon.springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class SpringMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservice1Application.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
		
	}

}
