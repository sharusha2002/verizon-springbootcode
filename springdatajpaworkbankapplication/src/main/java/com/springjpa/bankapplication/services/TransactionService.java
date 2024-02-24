package com.springjpa.bankapplication.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.bankapplication.entities.Transaction;
import com.springjpa.bankapplication.entities.User;
import com.springjpa.bankapplication.exceptions.BalanceException;
import com.springjpa.bankapplication.exceptions.TransactionNotFoundException;
import com.springjpa.bankapplication.exceptions.UserNotFoundException;
import com.springjpa.bankapplication.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;
	@Autowired
	UserService userService;
	
	

	
	public String selfDepositById(Transaction transaction,Integer userId) {
		transaction.setUser(new User(userId));
		transaction.setTransactionDateTime(LocalDateTime.now());
		transaction.setTransactionParty(null);
		transaction.setTransactionType("Self Deposit");
		User user=userService.updateBalance(userId,transaction.getTransactionType(),transaction.getTransactionAmount());
		if(user==null) {
			throw new UserNotFoundException();
		}
		else {
		repository.save(transaction);
		return "Deposited successfully current balance is: "+user.getBalance();
		}
	}
	
	public String transferById(Transaction transaction,Integer userId,Integer transactionParty) {
		transaction.setUser(new User(userId));
		transaction.setTransactionDateTime(LocalDateTime.now());
		transaction.setTransactionParty(transactionParty);
		transaction.setTransactionType("Debited");
	User user=userService.updatingUsersBalanceAfterTransaction(userId,transaction.getTransactionType(),transaction.getTransactionAmount(),transaction.getTransactionParty());
	if(user==null)
	{
		throw new UserNotFoundException();
	}
		else
		{	
			repository.save(transaction);
			return "Transferred "+transaction.getTransactionAmount() +"Sucessfully to :"+transactionParty;
		}
	}

	public String withdrawById(Transaction transaction, Integer userId) {
		transaction.setUser(new User(userId));
		transaction.setTransactionDateTime(LocalDateTime.now());
		transaction.setTransactionParty(null);
		transaction.setTransactionType("Withdrawl");
		User user = userService.updateBalance(userId,transaction.getTransactionType(),transaction.getTransactionAmount());
		if(user==null)
		throw new BalanceException();
		else
		{
			repository.save(transaction);
			return "Withdraw successfuly your remaining balance:"+user.getBalance();
		}
	}
	
	public Iterable<Transaction> getAllTransactions() {
		Iterable<Transaction> listOfTransactions = repository.findAll();
  		if(listOfTransactions.iterator().hasNext()) {
			return listOfTransactions;
		}
		throw new TransactionNotFoundException();
		
	}
	
	public Optional<Transaction> recentTransaction() {
		 Integer countOfTransactions = (int) repository.count();
		 Optional<Transaction> lastTransaction = repository.findById(countOfTransactions);
		 if(lastTransaction.isPresent())
			 return lastTransaction;
		 throw new TransactionNotFoundException();
	}
}
