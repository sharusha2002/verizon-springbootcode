package com.springjpa.bankapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springjpa.bankapplication.entities.User;
import com.springjpa.bankapplication.exceptions.SignUpException;
import com.springjpa.bankapplication.exceptions.UserNotFoundException;
import com.springjpa.bankapplication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public String addNewUser(User user) {
		Optional<User> existedUser = repository.findByEmail(user.getEmail());
		if (existedUser.isPresent()) {
			throw new SignUpException();
		} else {
			repository.save(user);
			return "User Saved Successfully";
		}

	}

	public String sigiIn(String email, String password) {
		Optional<User> existedUser = repository.findByEmail(email);
		if (existedUser.get().getPassword().equals(password)) {
			return "sign in successful";
		}
		throw new UserNotFoundException();
	}
	
	public Iterable<User> allUsers() {
		return repository.findAll();
	}
	public User getUserById(Integer id) {
		 Optional<User> user = repository.findById(id);
		 if(user.isPresent()) {
			 return user.get();
		 }
		throw new UserNotFoundException();
	}
	
	public String getBalanceById(Integer id) {
		Optional<User> user = repository.findById(id);
		if(user.isPresent()) {
			User balanceCheckingUser = user.get();  
			return "Your Balance is : "+balanceCheckingUser.getBalance();
		}
		throw new UserNotFoundException();
	}

	public User updateBalance(Integer id, String transactionType, Double transactionAmount) {
		Optional<User> optionalUser = repository.findById(id);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			Double currentBalance = user.getBalance();
			if (transactionType.equalsIgnoreCase("self deposit")) {
				Double updatedBalance = currentBalance + transactionAmount;
				user.setBalance(updatedBalance);
				return repository.save(user);
			} else {
				if (currentBalance >= transactionAmount) {
					Double updatedBalance = currentBalance - transactionAmount;
					user.setBalance(updatedBalance);
					return repository.save(user);
				}
				return null;
			}
		}
		return null;

	}

	public User updatingUsersBalanceAfterTransaction(Integer userId, String transactionType, Double transactionAmount,
			Integer transactionParty) {
		Optional<User> transactionPartyUser = repository.findById(transactionParty);
		Optional<User> transferringUser = repository.findById(userId);
		if (transactionPartyUser.isPresent()) {
			User creditingUser = transactionPartyUser.get();
			User debitingUser = transferringUser.get();
			Double balanceOfDebitingUser = debitingUser.getBalance();
			Double balanceOfCreditingUser = creditingUser.getBalance();
			if (balanceOfDebitingUser >= transactionAmount) {
				balanceOfDebitingUser = balanceOfDebitingUser - transactionAmount;
				balanceOfCreditingUser = balanceOfCreditingUser + transactionAmount;
				debitingUser.setBalance(balanceOfDebitingUser);
				creditingUser.setBalance(balanceOfCreditingUser);

				repository.save(debitingUser);
				return repository.save(creditingUser);

			}

			return null;

		}
		return null;

	}

}
