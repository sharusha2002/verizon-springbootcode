package com.hdfcbank;

import java.sql.Date;

public class TransactionDetails {

	private Integer transactionId;
	private Date transactionDate;
	private Double transactionAmount;
	private String transactionCategory;
	private Integer transactionUserId;
	private Integer transactionparty;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCategory() {
		return transactionCategory;
	}
	public void setTransactionCategory(String transactionCategory) {
		this.transactionCategory = transactionCategory;
	}
	public Integer getTransactionUserId() {
		return transactionUserId;
	}
	public void setTransactionUserId(Integer transactionUserId) {
		this.transactionUserId = transactionUserId;
	}
	public Integer getTransactionparty() {
		return transactionparty;
	}
	public void setTransactionparty(Integer transactionparty) {
		this.transactionparty = transactionparty;
	}
	public TransactionDetails(Date transactionDate, Double transactionAmount, String transactionCategory,
			Integer transactionUserId, Integer transactionparty) {
		super();
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionCategory = transactionCategory;
		this.transactionUserId = transactionUserId;
		this.transactionparty = transactionparty;
	}
	@Override
	public String toString() {
		return "TransactionDetails [ transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", transactionCategory=" + transactionCategory
				+ ", transactionUserId=" + transactionUserId + ", transactionparty=" + transactionparty + "]";
	}
	public TransactionDetails() {
		// TODO Auto-generated constructor stub
	}
}
