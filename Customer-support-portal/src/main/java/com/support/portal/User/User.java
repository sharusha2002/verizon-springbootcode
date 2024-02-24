package com.support.portal.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userid;

	@Column(name = "user_name")
	private String name;

	@Column(name = "user_email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "confirm_password")
	private String confirmpassword;

	@Column(name = "phone_number")
	private String phonenumber;
	
	public User(Integer userid) {
		this.userid = userid;
	}

}
