package com.verizon.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SampleController {

	@GetMapping("/message")
	public String welcomeMessage() {
		return "Welcome to home page.....";
	}
}
