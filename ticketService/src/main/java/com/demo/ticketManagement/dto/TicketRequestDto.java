package com.demo.ticketManagement.dto;

public class TicketRequestDto {
	
	/**
	 * Generates TicketRequestDto with parameter 
	 * trainScheduleId
	 */
	Long trainScheduleId;
	
	
	public Long getTrainScheduleId() {
		return trainScheduleId;
	}

	public void setTrainScheduleId(Long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}

	
}
