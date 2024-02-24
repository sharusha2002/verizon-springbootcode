package com.verizon.springbootjdbc.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseid;

	private String expensename;

	private Float expensecost;

	private Date expensedate;

	private String expensecategory;
	
	@ManyToOne
	User user;
	
	public Expense() {
		
	}

	public Expense(Integer expenseid, String expensename, Float expensecost, Date expensedate, String expensecategory,
			User user) {
		super();
		this.expenseid = expenseid;
		this.expensename = expensename;
		this.expensecost = expensecost;
		this.expensedate = expensedate;
		this.expensecategory = expensecategory;
		this.user = user;
	}

	public Integer getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(Integer expenseid) {
		this.expenseid = expenseid;
	}

	public String getExpensename() {
		return expensename;
	}

	public void setExpensename(String expensename) {
		this.expensename = expensename;
	}

	public Float getExpensecost() {
		return expensecost;
	}

	public void setExpensecost(Float expensecost) {
		this.expensecost = expensecost;
	}

	public Date getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Date expensedate) {
		this.expensedate = expensedate;
	}

	public String getExpensecategory() {
		return expensecategory;
	}

	public void setExpensecategory(String expensecategory) {
		this.expensecategory = expensecategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Expense [expenseid=" + expenseid + ", expensename=" + expensename + ", expensecost=" + expensecost
				+ ", expensedate=" + expensedate + ", expensecategory=" + expensecategory + ", user=" + user + "]";
	}

	
	
	
	
	

}
