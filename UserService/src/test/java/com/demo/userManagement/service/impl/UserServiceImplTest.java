package com.demo.userManagement.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.demo.userManagement.dao.UserDao;
import com.demo.userManagement.dto.LoginDto;
import com.demo.userManagement.dto.UserRequestDto;
import com.demo.userManagement.exception.InvalidCredentialsException;
import com.demo.userManagement.model.User;
import com.demo.userManagement.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	
	User user;
	LoginDto loginDto;
	UserRequestDto userRequestDto;
	@Mock
	UserDao userDao;
	@BeforeEach
	public void setUp()
	{
		userRequestDto = new UserRequestDto();
		userRequestDto.setContactNumber(125654656L);
		userRequestDto.setEmailId("sumag@gmail.com");
		userRequestDto.setPassword("suma");;
		userRequestDto.setUserName("suma");
	}
	
	@Test
	public void authenticateTest() throws InvalidCredentialsException
	{
		user = new User();
		user.setContactNumber(125654656L);
		user.setEmailId("sumag@gmail.com");
		user.setPassword("suma");
		user.setUserId(1L);
		user.setUserName("suma");
		when(userDao.findByUserNameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(user);
		//when
		Boolean isExists = userServiceImpl.authenticate("suma", "suma");
		assertTrue(isExists);
	}

	
}
