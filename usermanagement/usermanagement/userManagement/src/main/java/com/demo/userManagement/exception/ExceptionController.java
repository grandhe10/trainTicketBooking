package com.demo.userManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * @author haritha/monisha
 *
 */
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = ResourceNotFoundException.class)

	public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<String> exceptionHandler(InvalidCredentialsException invalidCredentialsException) {
		return new ResponseEntity<String>(invalidCredentialsException.getMessage(), HttpStatus.NOT_FOUND);
	}

}
