package com.verizon.telecombilling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.verizon.telecombilling.entities.IssueTicket;

@SpringBootApplication
public class TelecomBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomBillingApplication.class, args);
	}
	
	@Bean
	IssueTicket genIssueTicket() {
		return new IssueTicket();
	}


}
