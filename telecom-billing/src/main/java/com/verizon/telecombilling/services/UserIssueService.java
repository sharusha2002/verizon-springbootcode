package com.verizon.telecombilling.services;

import com.verizon.telecombilling.entities.UserIssue;


public interface UserIssueService {
	
	public void raiseIssue(UserIssue userIssue, Integer loggedInUserId);
	

}
