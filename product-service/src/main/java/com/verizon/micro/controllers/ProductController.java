package com.verizon.micro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.micro.entities.Product;
import com.verizon.micro.services.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	
	
	ProductService service;

	@Autowired
	public ProductController(ProductService service) {
				this.service = service;
	}
	
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Product createNewProduct(@RequestBody Product product) {
		return service.createNewProduct(product);
	}
	
	@PutMapping
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Product updateNewProduct(@PathVariable Integer id, @RequestBody Product product) {
		return service.updateNewProduct(product);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
	}
	
	@GetMapping
	@ResponseStatus(code=HttpStatus.OK)
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Optional<Product> getByProductById(@PathVariable Integer id) {
		return service.getByProductById(id);
	}
	
	@GetMapping("/name/{productName}")
	@ResponseStatus(code=HttpStatus.OK)
	public Product getByProductName(@PathVariable String productName) {
		return service.getByProductName(productName);
	}
	
	
	

}
