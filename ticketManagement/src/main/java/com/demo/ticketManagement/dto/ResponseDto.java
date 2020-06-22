package com.demo.ticketManagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ResponseDto {
	
	/**
	 * Generates class with parameters with trainId,trainNumber,
	 * departureTime,departureDate,arrivalTime,arrivalDate,
	 * message,ticketId
	 * 
	 */
	private Long trainId;
	private Long trainNumber;
	private LocalTime departureTime;
	private LocalDate departureDate;
	private LocalTime arrivalTime;
	private LocalDate arrivalDate;
	String message ;
	Long ticketId;
	public Long getTrainId() {
		return trainId;
	}
	public void setTrainId(Long trainId) {
		this.trainId = trainId;
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

}
