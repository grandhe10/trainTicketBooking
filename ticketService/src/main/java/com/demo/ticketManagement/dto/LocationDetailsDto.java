package com.demo.ticketManagement.dto;

/**
 * @author Suma
 *
 */
public class LocationDetailsDto {
	
	/**
	 * Generates class with fromLocation,toLocation
	 */
	String fromLocation;
	String toLocation;
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
