package com.demo.ticketManagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketDto {
	
	/**
	 * Generates TicketDto with parameters with trainNumber,
	 * departureTime,departureDate,arrivalTime,arrivalDate,
	 * message,ticketId,fromLocation.toLocation
	 * 
	 */
	private Long trainNumber;
	private LocalTime departureTime;
	private LocalDate departureDate;
	private LocalTime arrivalTime;
	private LocalDate arrivalDate;
	private String fromLocation;
	private String toLocation;
	private String message ;
	private Long ticketId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

}
