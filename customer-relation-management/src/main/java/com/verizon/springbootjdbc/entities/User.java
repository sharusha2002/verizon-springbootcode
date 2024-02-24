package com.verizon.springbootjdbc.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String email;

}
