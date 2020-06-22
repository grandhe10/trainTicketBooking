package com.demo.userManagement.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.userManagement.model.User;


/**
 * @author haritha/monisha
 *
 */
@Repository
public interface UserDao extends CrudRepository<User ,Long>{
	
	/**
	 * @param userName
	 * @param password
	 * @return user logged in
	 */
	public User findByUserNameAndPassword(String userName,String password );
	
	/**
	 * @param userId
	 * @return user details
	 */
	public Optional<User> findByUserId(Long userId);
}
