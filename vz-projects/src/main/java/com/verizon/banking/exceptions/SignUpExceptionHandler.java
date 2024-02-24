package com.verizon.banking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignUpExceptionHandler {
	
	@ExceptionHandler(value=SignUpException.class)
	public ResponseEntity<Object> signupexception(SignUpException signupexception){
		return new ResponseEntity<>("User already registered try using a different email id", HttpStatus.NOT_FOUND);
		
	}

}
