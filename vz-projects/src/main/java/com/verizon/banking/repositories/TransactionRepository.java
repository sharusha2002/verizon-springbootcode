package com.verizon.banking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.banking.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}
