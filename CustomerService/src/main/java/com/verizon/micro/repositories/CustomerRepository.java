package com.verizon.micro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.micro.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContainingIgnoreCaseOrSubscriptionContainingIgnoreCase(String name, String subscription);
}
