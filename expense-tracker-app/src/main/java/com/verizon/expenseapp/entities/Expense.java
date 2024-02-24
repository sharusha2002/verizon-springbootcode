package com.verizon.expenseapp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseid;
	
	private String expensename;
	
	private Float expensecost;
	
	private Date expensedate;
	
	@ManyToOne
	private User user;
	
	public Expense() {
		
	}

	public Expense(Integer expenseid, String expensename, Float expensecost, Date expensedate, User user) {
		super();
		this.expenseid = expenseid;
		this.expensename = expensename;
		this.expensecost = expensecost;
		this.expensedate = expensedate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Expense [expenseid=" + expenseid + ", expensename=" + expensename + ", expensecost=" + expensecost
				+ ", expensedate=" + expensedate + ", user=" + user + "]";
	}
	
	

}
