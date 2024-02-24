package com.support.portal.servicemanagement;

import java.time.LocalDateTime;
import com.support.portal.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private Integer serviceid;
	
	@Column(name = "category")
	private String category;

	@Column(name = "description")
	private String description;

	@Column(name = "priority_level")
	private String prioritylevel;
	
	@Column(name = "status")
	private String status;

	@Column(name = "date_of_requesting")
	private LocalDateTime dateCreated;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
