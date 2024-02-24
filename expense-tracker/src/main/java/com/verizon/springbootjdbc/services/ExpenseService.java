package com.verizon.springbootjdbc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.springbootjdbc.entities.Expense;
import com.verizon.springbootjdbc.entities.User;
import com.verizon.springbootjdbc.repositories.ExpenseRepository;
import com.verizon.springbootjdbc.repositories.UserRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository repository;
	
			
	public Optional<Expense> getExpenseById(Integer expenseid) {
		return repository.findById(expenseid);
	}
	
	public void addNewExpense(Expense expense) {
		repository.save(expense);
	}


}
