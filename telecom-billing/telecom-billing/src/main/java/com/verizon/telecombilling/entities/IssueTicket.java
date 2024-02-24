package com.verizon.telecombilling.entities;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;



@Entity
public class IssueTicket {

public	enum TicketStatus {	RAISED , ONPROCESS , RESOLVED  }
	
	@Id
	private String ticketId;
	
	@PrePersist
	public void generateTicketId() {
		this.ticketId=UUID.randomUUID().toString().substring(2,13);
	}
	
	private TicketStatus tikcetStatus;
	
	private Date expectedResolutionDate;
	
	@OneToOne
	private UserIssue userIssue;
	
	public IssueTicket() {
		
	}
	
	

	public IssueTicket( TicketStatus tikcetStatus, Date expectedResolutionDate, String userIssueId) {
		
	
		this.tikcetStatus = tikcetStatus;
		this.expectedResolutionDate = expectedResolutionDate;
		this.userIssue = new UserIssue(userIssueId);
	}









	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public TicketStatus getTikcetStatus() {
		return tikcetStatus;
	}

	public void setTikcetStatus(TicketStatus tikcetStatus) {
		this.tikcetStatus = tikcetStatus;
	}

	public Date getExpectedResolutionDate() {
		return expectedResolutionDate;
	}

	public void setExpectedResolutionDate(Date expectedResolutionDate) {
		this.expectedResolutionDate = expectedResolutionDate;
	}

	public UserIssue getUserIssue() {
		return userIssue;
	}

	public void setUserIssue(UserIssue userIssue) {
		this.userIssue = userIssue;
	}
	
	
	
}
