package com.demo.trainManagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seats {
	@Id
	private Long seatId;
	private Long trainScheduleId;
	private int threeTierAC;
	private int twoTierAC;
	private int sleeper;
	private int general;
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	public Long getTrainScheduleId() {
		return trainScheduleId;
	}
	public void setTrainScheduleId(Long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}
	public int getThreeTierAC() {
		return threeTierAC;
	}
	public void setThreeTierAC(int threeTierAC) {
		this.threeTierAC = threeTierAC;
	}
	public int getTwoTierAC() {
		return twoTierAC;
	}
	public void setTwoTierAC(int twoTierAC) {
		this.twoTierAC = twoTierAC;
	}
	public int getSleeper() {
		return sleeper;
	}
	public void setSleeper(int sleeper) {
		this.sleeper = sleeper;
	}
	public int getGeneral() {
		return general;
	}
	public void setGeneral(int general) {
		this.general = general;
	}
	
	

}
