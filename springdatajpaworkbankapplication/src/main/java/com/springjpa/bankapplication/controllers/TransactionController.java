package com.springjpa.bankapplication.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.bankapplication.entities.Transaction;
import com.springjpa.bankapplication.services.TransactionService;

@RestController
@RequestMapping("api/v1")
public class TransactionController {

	@Autowired
	TransactionService service;
	
	@PostMapping("/transactions/users/deposit/{userId}")
	public String selfDepositById(@RequestBody Transaction transaction, @PathVariable Integer userId) {
		return service.selfDepositById(transaction, userId);
	}
	
	@PostMapping("/transactions/users/withdraw/{userId}")
	public String withdrawById(@RequestBody Transaction transaction, @PathVariable Integer userId) {
		return service.withdrawById(transaction, userId);
	}
	
	@PostMapping("/transactions/users/transfer/{userId}")
	public void transferById(@RequestBody Transaction transaction,@PathVariable Integer userId,@RequestParam Integer transactionParty) {
	service.transferById(transaction, userId, transactionParty);
	}
	
	@GetMapping("/transactions/users")
	public Iterable<Transaction> getAllTransactions() {
		return service.getAllTransactions();
	}
	
	@GetMapping("/transactions/users/recent")
	public Optional<Transaction> recentTransaction() {
		return service.recentTransaction();
	}
	
//	@GetMapping("")

}
