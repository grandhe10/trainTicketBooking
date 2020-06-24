package com.demo.ticketManagement.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger {
	/**
	 * Generates Passenger table with passengerId,
	 *  passengerName,age,seatType,ticketId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long passengerId;
	private String passengerName;
	private int age;
	@Enumerated(EnumType.STRING)
	private SeatOptions seatType;
	private Long ticketId;

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

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

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public SeatOptions getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatOptions seatType) {
		this.seatType = seatType;
	}
}
