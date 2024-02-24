package com.verizon.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.verizon.banking.services.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService service;

}
