package com.demo.ticketManagement.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.demo.ticketManagement.model.SeatOptions;

public class SeatDto {

	/**
	 * Generates SeatDto with seatType and trainScheduleId 
	 */
	@Enumerated(EnumType.STRING)
	private SeatOptions seatType;
	private Long trainScheduleId;
	public SeatOptions getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatOptions seatType) {
		this.seatType = seatType;
	}
	public Long getTrainScheduleId() {
		return trainScheduleId;
	}
	public void setTrainScheduleId(Long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}
	
}
