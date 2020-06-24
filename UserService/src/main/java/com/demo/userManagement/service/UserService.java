package com.demo.userManagement.service;

import com.demo.userManagement.dto.UserRequestDto;
import com.demo.userManagement.exception.InvalidCredentialsException;

public interface UserService {

	void saveUserDetails(UserRequestDto userRequestDto);

	boolean authenticate(String userName, String password) ;
	
	UserRequestDto getUserDetailsByUserId(Long userId);

}
