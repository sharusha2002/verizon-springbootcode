package com.verizon.micro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.micro.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  Product findByProductName(String productName);
}
