package com.verizon.springbootjdbc.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	BookService service;
	
	
	@GetMapping
	List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	
	@GetMapping("/book/{id}")
	Book getBookById(@PathVariable Integer id) {
		return service.getBookById(id);
		}
	
	@GetMapping("/users")
	List<Object> getAllUsers(){
		return service.getAllUsers();
	}
	
	@PostMapping("/user")
	void addNewUser(@RequestBody User user) {
		service.addNewUser(user);
	}
	
	@PutMapping("/user/{id}")
	String updateUser(@PathVariable Integer id) {
		 return service.updateUser(id);
	}

	


}
