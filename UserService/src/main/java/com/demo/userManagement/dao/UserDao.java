package com.demo.userManagement.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.userManagement.model.User;



@Repository
public interface UserDao extends CrudRepository<User ,Long>{
	
	public User findByUserNameAndPassword(String userName,String password );
	
	public Optional<User> findByUserId(Long userId);
}
