package com.verizon.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMgmtApplication.class, args);
	}

}
