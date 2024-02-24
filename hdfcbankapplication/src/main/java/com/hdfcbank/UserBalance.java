package com.hdfcbank;

public class UserBalance {

	private Integer userAccountNumber;
	private Integer userId;
	private Double userBalance;
	public Integer getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(Integer userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}
	@Override
	public String toString() {
		return "UserBalance [userAccountNumber=" + userAccountNumber + ", userId=" + userId + ", userBalance="
				+ userBalance + "]";
	}
	public UserBalance(Integer userAccountNumber, Integer userId, Double userBalance) {
		super();
		this.userAccountNumber = userAccountNumber;
		this.userId = userId;
		this.userBalance = userBalance;
	}
	public UserBalance() {
		// TODO Auto-generated constructor stub
	}
}
