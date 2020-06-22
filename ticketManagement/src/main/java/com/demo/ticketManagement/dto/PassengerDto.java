package com.demo.ticketManagement.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.demo.ticketManagement.model.SeatOptions;

public class PassengerDto {
	/**
	 * Generates class with passengerName,age and seatType
	 */
	private String passengerName;
	private int age;
	@Enumerated(EnumType.STRING)
	private SeatOptions seatType;

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SeatOptions getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatOptions seatType) {
		this.seatType = seatType;
	}
}
