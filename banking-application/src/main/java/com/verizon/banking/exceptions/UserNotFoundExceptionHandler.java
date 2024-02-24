package com.verizon.banking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotFoundExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> usernotfoundexception(UserNotFoundException usernotfoundexception){
		return new ResponseEntity<Object>("User not found. Enter valid email", HttpStatus.NOT_FOUND);
	}

}
