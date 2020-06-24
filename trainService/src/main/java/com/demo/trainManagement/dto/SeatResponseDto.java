package com.demo.trainManagement.dto;

public class SeatResponseDto {
	public SeatResponseDto() {
		super();
	}
	private int threeTierAC;
	private int twoTierAC;
	private int sleeper;
	private int general;
	private String message;
	public SeatResponseDto(String message) {
		super();
		this.message = message;
	}
	public int getThreeTierAC() {
		return threeTierAC;
	}
	public void setThreeTierAC(int threeTierAC) {
		this.threeTierAC = threeTierAC;
	}
	public int getTwoTierAC() {
		return twoTierAC;
	}
	public void setTwoTierAC(int twoTierAC) {
		this.twoTierAC = twoTierAC;
	}
	public int getSleeper() {
		return sleeper;
	}
	public void setSleeper(int sleeper) {
		this.sleeper = sleeper;
	}
	public int getGeneral() {
		return general;
	}
	public void setGeneral(int general) {
		this.general = general;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
