package com.springjpa.bankapplication.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	
	
	private  LocalDateTime transactionDateTime;
	
	private Double transactionAmount;
	
	private String transactionType;
	
	
	private Long transactionMobile;
	
	private Integer transactionParty;
	
	@ManyToOne
	private User user;

	public Transaction(LocalDateTime transactionDateTime, Double transactionAmount, String transactionType, Long transactionMobile,
			Integer transactionParty, Integer userId) {
		
//		this.transactionDateTime=transactionDateTime;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionMobile = transactionMobile;
//		this.transactionParty=transactionParty;
		this.user = new User(userId);
	}
	 
	

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDateTime=" + transactionDateTime
				+ ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType
				+ ", transactionMobile=" + transactionMobile + ", user=" + user + "]";
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getTransactionMobile() {
		return transactionMobile;
	}
	public void setTransactionMobile(Long transactionMobile) {
		this.transactionMobile = transactionMobile;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 public Integer getTransactionParty() {
			return transactionParty;
		}

		public void setTransactionParty(Integer transactionParty) {
			this.transactionParty = transactionParty;
		}
	
}
