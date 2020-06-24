package com.demo.userManagement.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.userManagement.dao.UserDao;
import com.demo.userManagement.dto.UserRequestDto;
import com.demo.userManagement.exception.InvalidCredentialsException;
import com.demo.userManagement.model.User;
import com.demo.userManagement.service.UserService;



@Service
public class UserServiceImpl  implements UserService{
   @Autowired
   UserDao userDao;
	@Override
	public void saveUserDetails(UserRequestDto userRequestDto) {
		User user = new User();
		BeanUtils.copyProperties(userRequestDto,user);
		userDao.save(user);
	
	}
	@Override
	public boolean authenticate(String userName, String password)  {
		User user=userDao.findByUserNameAndPassword(userName, password);
		if(user!=null) return true;
		throw new InvalidCredentialsException("invalid credential check Username or password",HttpStatus.NOT_FOUND);
	}
	@Override
	public UserRequestDto getUserDetailsByUserId(Long userId) {
		Optional<User> user = userDao.findByUserId(userId);
		UserRequestDto userDto = new UserRequestDto();
		if(user.isPresent())
		{
			BeanUtils.copyProperties(user.get(), userDto);
		return userDto;
		}
		else
		return new UserRequestDto(0L);
	}

}
