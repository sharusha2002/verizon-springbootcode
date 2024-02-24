package com.hdfcbank;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserSign {
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
	}
	
  int  signUp(UserDetails user) {
		String qry="insert into userdetails (userName,userEmail,userPassword) values (?,?,?)";
		if(this.duplicateEmailChecking(user.getUserEmail()))
			return 0;
		else
		  return jdbcTemplate.update(qry, new Object[] {user.getUserName(),user.getUserEmail(),user.getUserPassword()});
				}
  
  boolean duplicateEmailChecking(String email) {
	  
	  
	  String qry="select userEmail from userdetails where userEmail=?";
	  String existingEmail= jdbcTemplate.queryForObject(qry, String.class,new Object[] {email});
//	  String qry="select userEmail from userdetails where userEmail=:email";
//	  MapSqlParameterSource source=new MapSqlParameterSource()
//			  .addValue("email", email);
//	  String existingEmail= namedParameterJdbcTemplate.queryForObject(qry, source,String.class);
	  if(existingEmail.equalsIgnoreCase(email))
		  return true;
	  else
		  return false;
	  
  }
  
  
  boolean signIn(String signInEmail, String signInPassword) {
	  String qry="select userPassword from userdetails where userEmail=:signInEmail";
	  MapSqlParameterSource source =new MapSqlParameterSource()
			  .addValue("signInEmail",signInEmail );
	  String returnedPasswordFromuserdetails=namedParameterJdbcTemplate.queryForObject(qry, source, String.class);
	  if(returnedPasswordFromuserdetails.equals(signInPassword))
		  return true;
	  return false;
  }

	
	
	

}
