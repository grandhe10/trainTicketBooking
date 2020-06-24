package com.demo.userManagement.controller;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.userManagement.dto.LoginDto;
import com.demo.userManagement.exception.InvalidCredentialsException;
import com.demo.userManagement.exception.ResourceNotFoundException;
import com.demo.userManagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)

public class UserControllerTest {
	
	@Mock
	UserService userService;
	
	MockMvc mockMvc;
	ObjectMapper objectMapper;
	
	@InjectMocks
	UserController userController;
	
	LoginDto loginDto;
	@BeforeEach
	public void setUp()
	{
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		loginDto = new LoginDto();
		loginDto.setPassword("1234");
		loginDto.setUserName("user");
		
	}

	@Test
	public void login() throws Exception
	{
		//given
		when(userService.authenticate("user", "1234")).thenReturn(true);
		
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginDto)))
		        .andExpect(status().isOk())
		        .andExpect(content().string("user logged in successfully"));       	
		verify(userService).authenticate("user", "1234");
	}
	
	@Test
	public void login2() throws Exception
	{
		//given
		when(userService.authenticate("user", "1234")).thenReturn(false);
		assertThrows(ResourceNotFoundException.class, () -> userService.authenticate("user", "1234"));
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginDto)))
		        .andExpect(status().isNotFound())
		        .andExpect(content().string("User credentials incorrect!!"));       	
		verify(userService).authenticate("user", "1234");
		
		//
	}
}
