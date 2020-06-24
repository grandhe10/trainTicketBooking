package com.demo.ticketManagement.dto;

public class UserResponseDto {
	
	/**
	 * Generates UserResponseDto with paramters userName and emailId
	 */
	private String userName;
	private String emailId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setMailId(String emailId) {
		this.emailId = emailId;
	}
	

}
