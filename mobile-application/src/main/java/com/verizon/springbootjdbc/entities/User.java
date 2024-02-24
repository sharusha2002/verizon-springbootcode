package com.verizon.springbootjdbc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String mobileNo;
	
	private Float balance;
	
	public User() {
		
	}

	public User(Integer id, String mobileNo, Float balance) {
		super();
		this.id = id;
		this.mobileNo = mobileNo;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mobileNo=" + mobileNo + ", balance=" + balance + "]";
	}
	
	

}
