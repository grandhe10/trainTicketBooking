package com.demo.ticketManagement.dto;

public class SeatDetailsDto {
	
	
	/**
	 * Generates SeatDetailsDto with parameters
	 * threeTierAc,twoTierAC,sleeper,general and 
	 * message
	 */
	private int threeTierAC;
	private int twoTierAC;
	private int sleeper;
	private int general;
	private String message;
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
