package com.verizon.banking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.banking.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;
}
