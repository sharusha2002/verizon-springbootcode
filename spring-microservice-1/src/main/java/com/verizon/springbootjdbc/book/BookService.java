package com.verizon.springbootjdbc.book;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {
	
	@Autowired
	RestTemplate restTemplate;
	
	List<Book> listOfBooks = Arrays.asList(
			new Book(101, "Rich Dad Poor Dad", "self-gelf", "A Book about managing money"),
	        new Book(102, "The power of subconcious mind", "self-helf", "Building confidence and growing our mindset"),
	        new Book(212, "The secret the power", "self-help", "About the universal law of attraction"),
	        new Book(104, "Alchemist", "self-help", "Find our own desires"));
	
	List<Book> getAllBooks(){
		return listOfBooks;
	}
	
	Book getBookById(@PathVariable Integer id) {
		return new Book(102, "The power of subconcious mind", "self-helf", "Building confidence and growing our mindset");
	}
	
	List<Object> getAllUsers(){
		String urlOfOtherService="http://localhost:8080/api/v1/users";
		Object returnedObject = restTemplate.getForObject(urlOfOtherService, Object.class);
		return Arrays.asList(returnedObject);
	}
	
	public User addNewUser(User user) {
		String urlOfOtherservice = "http://localhost:8080/api/v1/user";
		return restTemplate.postForObject(urlOfOtherservice, user, User.class);
	}
	
	public String updateUser(Integer id) {
        String urlOfOtherService = "http://localhost:8080/api/v1/user/" + id;
        try {
            restTemplate.put(urlOfOtherService, id);
            return "User updated successfully";
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return "Failed to update user";
        }
    }

}
