package com.verizon.telecombilling.services;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.telecombilling.entities.IssueTicket;
import com.verizon.telecombilling.entities.IssueTicket.TicketStatus;
import com.verizon.telecombilling.entities.UserIssue;
import com.verizon.telecombilling.repositories.IssueTicketRepository;

@Service
public class IssueTicketServiceImpl implements IssueTicketService {
 
	private IssueTicketRepository repository;
	
	@Autowired
	IssueTicket issueTicket;
	
    @Autowired
	public void setRepository(IssueTicketRepository repository) {
	
		this.repository = repository;
	}

	@Override
	public void generateTicket(String userIssueId) {	  
	 issueTicket.setTikcetStatus(TicketStatus.RAISED);
	 issueTicket.setUserIssue(new UserIssue(userIssueId));
	 //long millis = System.currentTimeMillis();
	 Calendar calendar = Calendar.getInstance();
     calendar.add(Calendar.DATE, +3);
     issueTicket.setExpectedResolutionDate((Date) calendar.getTime());
//	 Date expectedDate = currentDate;
	 repository.save(issueTicket);
		
		
	}
	
    
}
