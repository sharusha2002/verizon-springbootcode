package com.support.portal.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {
	@GetMapping
	public String welcome() {
		return "Welcome to the Authentication Service";
	}
}