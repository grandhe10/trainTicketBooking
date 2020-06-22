package com.demo.ticketManagement.service;

import com.demo.ticketManagement.dto.LoginRequestDto;
import com.demo.ticketManagement.dto.TicketDto;
import com.demo.ticketManagement.dto.TrainDetailsDto;
import com.demo.ticketManagement.exception.InvalidCredentialsException;

/**
 * @author 91970
 *
 */
public interface TicketService {

	/**
	 * This method is used to book a tciket
	 * @param userId
	 * @param trainScheduleId
	 * @return TicketDto with message
	 */
	TicketDto bookTicket(Long userId, Long trainScheduleId);
	/**
	 * This method is used to get particular details
	 * @param userId
	 * @return TicketDetails
	 */
	TrainDetailsDto getTrainDetails(Long trainScheduleId);

	/**
	 * @param loginRequestDto
	 * @return String "User logged in " if user exits else "invalid credentials !!!!"
	 * @throws InvalidCredentialsException
	 */
	String authenticateUser(LoginRequestDto loginRequestDto) throws InvalidCredentialsException;

}
