package com.ing.matrimony.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = {PasswordNotMatchException.class})
	public ResponseEntity<ResponseError> ageException(Exception e){
		ResponseError error = new ResponseError(e.getMessage(),HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}
