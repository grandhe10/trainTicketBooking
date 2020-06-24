package com.demo.userManagement.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException(String exception, HttpStatus status) {
		super(exception);
	}
}