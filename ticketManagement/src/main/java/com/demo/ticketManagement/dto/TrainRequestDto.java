package com.demo.ticketManagement.dto;

public class TrainRequestDto {
	
	/**
	 * Generates TrainRequestDto with fromLocation,
	 * toLocation,departureDate
	 */
	private String fromLocation;
	private String toLocation;
	private String departureDate; 
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
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	

}
