package com.verizon.springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootStarterJdbctemplate1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootStarterJdbctemplate1Application.class, args);
	}

}
