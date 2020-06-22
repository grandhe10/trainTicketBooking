package com.demo.ticketManagement.service;

import com.demo.ticketManagement.dto.SeatDetailsDto;
import com.demo.ticketManagement.dto.TrainRequestDto;
/**
 * @author 91970
 *
 */
public interface TrainService {
	/**
	 * This method is used to get list of trains that matches with the requested data 
	 * @param trainRequestDto
	 * @return trainDetails
	 */
	public String getAllTrainsByLocation(TrainRequestDto trainRequestDto);

	/**
	 * This method is used to get the available seat Details 
	 * @param trainScheduleId
	 * @return seat details 
	 */
	SeatDetailsDto getAvailableSeats(Long trainScheduleId);
	
}
