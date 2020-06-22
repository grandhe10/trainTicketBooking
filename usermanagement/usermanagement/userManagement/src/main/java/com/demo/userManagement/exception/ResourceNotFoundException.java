package com.demo.userManagement.exception;

import org.springframework.http.HttpStatus;
/**
 * @author haritha/monisha
 *
 */
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String exception, HttpStatus status) {
		super(exception);
	}
}