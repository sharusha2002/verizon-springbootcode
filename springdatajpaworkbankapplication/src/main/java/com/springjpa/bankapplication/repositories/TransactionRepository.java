package com.springjpa.bankapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.bankapplication.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
