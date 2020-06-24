package com.demo.ticketManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	/**
	 * Generates table with ticketId,userId and trainScheduleId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long ticketId;
	private Long userId;
	private Long trainScheduleId;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTrainScheduleId() {
		return trainScheduleId;
	}

	public void setTrainScheduleId(Long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}

}
