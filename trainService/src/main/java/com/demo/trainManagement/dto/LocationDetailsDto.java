package com.demo.trainManagement.dto;

public class LocationDetailsDto {
	
	public LocationDetailsDto() {
		super();
	}
	public LocationDetailsDto(String message) {
		super();
		this.message = message;
	}
	private String fromLocation;
	private String toLocation;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
