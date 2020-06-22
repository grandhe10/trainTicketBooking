package com.demo.userManagement.dto;
/**
 * @author haritha/monisha
 *
 */
public class UserRequestDto {
	public UserRequestDto() {
		super();
	}
	public UserRequestDto(Long contactNumber) {
		super();
		this.contactNumber = contactNumber;
	}
	private String userName;
	private String password;
	private Long contactNumber;
	private String emailId;
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
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
