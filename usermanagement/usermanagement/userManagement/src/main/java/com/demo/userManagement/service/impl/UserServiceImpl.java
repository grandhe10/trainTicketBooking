package com.demo.userManagement.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.userManagement.dao.UserDao;
import com.demo.userManagement.dto.UserRequestDto;
import com.demo.userManagement.exception.InvalidCredentialsException;
import com.demo.userManagement.model.User;
import com.demo.userManagement.service.UserService;

/**
 * @author haritha/monisha
 *
 */

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
	public boolean authenticate(String userName, String password) throws InvalidCredentialsException {
		User user=userDao.findByUserNameAndPassword(userName, password);
		if(user!=null) return true;
		throw new InvalidCredentialsException("invalid credential check Username or password");
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
