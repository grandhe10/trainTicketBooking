package com.demo.ticketManagement.dto;

public class LoginRequestDto {
	
	/**
	 * Generates class with userName,password
	 */
	String userName;
	String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
