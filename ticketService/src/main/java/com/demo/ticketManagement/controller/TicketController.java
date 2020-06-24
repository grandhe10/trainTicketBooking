package com.demo.ticketManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.ticketManagement.dto.ItenaryResponseDto;
import com.demo.ticketManagement.dto.LoginRequestDto;
import com.demo.ticketManagement.dto.TicketDto;
import com.demo.ticketManagement.dto.TicketRequestDto;
import com.demo.ticketManagement.exception.InvalidCredentialsException;
import com.demo.ticketManagement.service.PassengerService;
import com.demo.ticketManagement.service.TicketService;

/**
 * @author Suma
 *
 */
@RestController
public class TicketController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	TicketService ticketService;
	@Autowired
	PassengerService passengerService;

	/**
	 * This method is used to book ticket 
	 * @param ticketRequestDto
	 * @param userId
	 * @return TicketDto with TicketDetails like location details and trainDetails of selected train
	 */
	@PostMapping("users/{userId}")
	public ResponseEntity<TicketDto> bookTicket(@RequestBody TicketRequestDto ticketRequestDto,
			@PathVariable("userId") Long userId) {
		TicketDto ticketDto = ticketService.bookTicket(userId, ticketRequestDto.getTrainScheduleId());

		return new ResponseEntity<TicketDto>(ticketDto, HttpStatus.CREATED);

	}

	/**
	 * This method is used to get the ticket details of a particular ticket
	 * @param ticketId
	 * @return complete ticket details
	 */
	@GetMapping("tickets/{ticketId}")
	public ResponseEntity<ItenaryResponseDto> getTicketDateails(@PathVariable("ticketId") Long ticketId) {
		ItenaryResponseDto itenaryResponseDto = passengerService.getItenary(ticketId);
		return new ResponseEntity<ItenaryResponseDto>(itenaryResponseDto, HttpStatus.OK);
	}

	/**
	 * This method is used to authenticate user 
	 * @param loginRequestDto
	 * @return message "User logged in" if user exists else "invalid credentials" 
	 */
	@PostMapping("users/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
		try {
			ticketService.authenticateUser(loginRequestDto);
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("User logged in", HttpStatus.ACCEPTED);
	}
}
