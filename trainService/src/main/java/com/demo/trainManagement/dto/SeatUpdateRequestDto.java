package com.demo.trainManagement.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.demo.trainManagement.model.SeatOptions;

public class SeatUpdateRequestDto {
	public SeatOptions getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatOptions seatType) {
		this.seatType = seatType;
	}

	@Enumerated(EnumType.STRING)
	private SeatOptions seatType;
	private long trainScheduleId;
	public long getTrainScheduleId() {
		return trainScheduleId;
	}

	public void setTrainScheduleId(long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}

}
