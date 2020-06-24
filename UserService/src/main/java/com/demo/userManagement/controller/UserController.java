package com.demo.userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.userManagement.dto.LoginDto;
import com.demo.userManagement.dto.UserRequestDto;
import com.demo.userManagement.exception.InvalidCredentialsException;
import com.demo.userManagement.exception.ResourceNotFoundException;
import com.demo.userManagement.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/users")
	public String register(@RequestBody UserRequestDto userRequestDto) {
		userService.saveUserDetails(userRequestDto);
		return "Register successfully";
	}

	@PostMapping(value = "/users/login")
	public ResponseEntity<String> login(@RequestBody LoginDto logindto)
			throws ResourceNotFoundException, InvalidCredentialsException {

		if (userService.authenticate(logindto.getUserName(), logindto.getPassword()))
			return new ResponseEntity<String>("user logged in successfully", HttpStatus.OK);
		else
			throw new ResourceNotFoundException("User credentials incorrect!!", HttpStatus.NOT_FOUND);

	}

	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserRequestDto> getUserDetails(@PathVariable("userId") Long userId) {
		if (userService.getUserDetailsByUserId(userId).getContactNumber() == 0L)
			throw new ResourceNotFoundException("no user found!!!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserRequestDto>(userService.getUserDetailsByUserId(userId), HttpStatus.OK);
	}

}
