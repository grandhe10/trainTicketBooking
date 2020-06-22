package com.demo.ticketManagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ItenaryResponseDto {
	/** 
	 * Generates class with trainNumber,departureTime,departureDate,
	 * arrivalTime,arrivalDate,fromLocation,toLocation,passengerDtoList,
	 * userName,password
	 */
	private Long trainNumber;
	private LocalTime departureTime;
	private LocalDate departureDate;
	private LocalTime arrivalTime;
	private LocalDate arrivalDate;
	private String fromLocation;
	private String toLocation;
	List<PassengerDto> passengerDtoList;
	private String userName;
	private String emailId;

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

	public List<PassengerDto> getPassengerDtoList() {
		return passengerDtoList;
	}

	public void setPassengerDtoList(List<PassengerDto> passengerDtoList) {
		this.passengerDtoList = passengerDtoList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
