package com.verizon.micro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.micro.entities.Product;
import com.verizon.micro.repositories.ProductRepository;

@Service
public class ProductService {
	
	public ProductRepository repository;

	@Autowired
	public ProductService(ProductRepository repository) {
		
		this.repository = repository;
	}
	
	public Product createNewProduct(Product product) {
		return repository.save(product);
	}
	
	public Product updateNewProduct(Product product) {
		return repository.save(product);
	}
	
	public void deleteProduct(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	public Optional<Product> getByProductById(Integer id) {
		return repository.findById(id);
	}
	public Product getByProductName(String productName) {
		return repository.findByProductName(productName);
	}
	

}
