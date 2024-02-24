package com.springjpa.bankapplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private Long mobile;
	
	private Double balance;

	

	public User(String name, String email, String password, Long mobile, Double balance) {
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.balance = balance;
	}

	public User(Integer id) {
		super();
		this.id = id;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
