package com.verizon.springbootjdbc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.springbootjdbc.entities.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
	}
