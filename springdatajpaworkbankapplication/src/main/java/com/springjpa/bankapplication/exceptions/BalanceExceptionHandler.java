package com.springjpa.bankapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BalanceExceptionHandler {

	@ExceptionHandler(value = BalanceException.class)
    public ResponseEntity<Object> exception(BalanceException balanceException){
        return new ResponseEntity<>("Insufficient Balance", HttpStatus.NOT_FOUND);
    }
}
