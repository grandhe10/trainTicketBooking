package com.demo.userManagement.service;

import com.demo.userManagement.dto.UserRequestDto;
import com.demo.userManagement.exception.InvalidCredentialsException;
/**
 * @author haritha/monisha
 *
 */
public interface UserService {

	void saveUserDetails(UserRequestDto userRequestDto);

	boolean authenticate(String userName, String password) throws InvalidCredentialsException;
	
	UserRequestDto getUserDetailsByUserId(Long userId);

}
