package com.demo.ticketManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ticketManagement.dto.PassengerDto;
import com.demo.ticketManagement.dto.PassengerRequestDto;
import com.demo.ticketManagement.exception.ResourceNotFoundException;
import com.demo.ticketManagement.service.PassengerService;

/**
 * @author Suma
 *
 */
@RestController
public class PassengerController {
	@Autowired
	PassengerService passengerService;
	
	/**
	 * This method is used to add passengerDetails for a particular ticket
	 * @param passengerRequestDtoList
	 * @param ticketId
	 * @return message 
	 */
	@PostMapping("/tickets/{ticketId}/passengers")
	public ResponseEntity<String> addPassengerDetails(@RequestBody List<PassengerRequestDto> passengerRequestDtoList,@PathVariable("ticketId") Long ticketId)
	{
		passengerService.addPassengerDetails1(passengerRequestDtoList,ticketId);
		return new ResponseEntity<String>("passenger details added",HttpStatus.CREATED);
	}

	/**
	 * This method is used to get passengerDetails with a particular ticket
	 * @param ticketId
	 * @return passenger details list
	 */
	@GetMapping("tickets/{ticketId}/passengers")
	public ResponseEntity<List<PassengerDto>> getPassengerDetails(@PathVariable("ticketId") Long ticketId)
	{
		List<PassengerDto> passengerDtoList = passengerService.getPassengersByTicketId(ticketId);
		if(passengerDtoList.isEmpty())
			throw new ResourceNotFoundException("No passngers found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<PassengerDto>>(passengerDtoList,HttpStatus.OK);
	}
	
	
}
