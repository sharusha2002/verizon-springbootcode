package com.customer.support.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
	
	private String userName;
	
	private String userMail;
	
	private String password;
	
	private String state;
	
	private String city;
	
	private Long mobileNo;

	
	public User(Integer userId) {
		
	}
	
	public User() {
		
	}

	public User(Integer userId, String userName, String userMail, String password, String state, String city,
			Long mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMail = userMail;
		this.password = password;
		this.state = state;
		this.city = city;
		this.mobileNo = mobileNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + ", password=" + password
				+ ", state=" + state + ", city=" + city + ", mobileNo=" + mobileNo + "]";
	}
    
	
	
	
}

