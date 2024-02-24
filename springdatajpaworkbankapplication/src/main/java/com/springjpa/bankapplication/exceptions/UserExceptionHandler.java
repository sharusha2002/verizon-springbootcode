package com.springjpa.bankapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>("User not Registered and doesn't have any account", HttpStatus.NOT_FOUND);
    }
}
