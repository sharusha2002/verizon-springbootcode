package com.springjpa.bankapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignUpExceptionHandler {

	@ExceptionHandler(value = SignUpException.class)
    public ResponseEntity<Object> exception(SignUpException signUpException){
        return new ResponseEntity<>("User Already Registered and try to register with new mail", HttpStatus.NOT_FOUND);
    }
}
