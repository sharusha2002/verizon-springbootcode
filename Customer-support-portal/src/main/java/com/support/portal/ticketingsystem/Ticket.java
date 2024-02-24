package com.support.portal.ticketingsystem;

import java.util.Date;

import com.support.portal.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {
	
	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
	    @Column(name = "title")
	    private String title;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "category")
	    private String category;

	    @Column(name = "status")
	    private String status;

	    @Column(name = "priority")
	    private String priority;

//	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created_at")
	    private Date createdAt;

//	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "updated_at", nullable = false)
	    private Date updatedAt;
	    
	    @ManyToOne
	    private User user;

		public Ticket(String title, String description, String category, String status, String priority, Date createdAt,
				Date updatedAt, Integer userId) {
			super();
			this.title = title;
			this.description = description;
			this.category = category;
			this.status = status;
			this.priority = priority;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.user = new User(userId);
		}
	    
	    

}
