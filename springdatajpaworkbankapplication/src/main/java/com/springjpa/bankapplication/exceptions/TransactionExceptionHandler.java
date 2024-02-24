package com.springjpa.bankapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {

	 @ExceptionHandler(value = TransactionNotFoundException.class)
	    public ResponseEntity<Object> exception(TransactionNotFoundException transactionNotFoundException){
	        return new ResponseEntity<>("No Transactions were done", HttpStatus.NOT_FOUND);
	    }
}
