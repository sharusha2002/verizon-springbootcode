package com.springjpa.bankapplication;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdatajpaworkbankapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaworkbankapplicationApplication.class, args);
		System.out.println(LocalDateTime.now( ));
	}

}
