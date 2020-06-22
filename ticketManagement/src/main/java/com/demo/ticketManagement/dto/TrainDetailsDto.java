package com.demo.ticketManagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrainDetailsDto {
	/**
	 * Generates TicketDto with parameters with trainNumber,
	 * departureTime,departureDate,arrivalTime,arrivalDate
	 * 
	 */
	
	private Long trainId;
	private Long trainNumber;
	private LocalTime departureTime;
	private LocalDate departureDate;
	private LocalTime arrivalTime;
	private LocalDate arrivalDate;
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

}
