package com.verizon.telecombilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.telecombilling.entities.UserIssue;
import com.verizon.telecombilling.services.UserIssueService;

@RestController
@RequestMapping("api/v1")
public class UserIssueController {
	
	@Autowired
	UserIssueService userIssueService;
	
	@PostMapping("/issue")
	public void raiseIssue(@RequestBody UserIssue userIssue , @RequestParam Integer loggedInUserId) {
		userIssueService.raiseIssue(userIssue, loggedInUserId);
	}

}
