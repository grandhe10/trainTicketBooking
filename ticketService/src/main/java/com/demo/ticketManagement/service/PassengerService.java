package com.demo.ticketManagement.service;

import java.util.List;

import com.demo.ticketManagement.dto.ItenaryResponseDto;
import com.demo.ticketManagement.dto.PassengerDto;
import com.demo.ticketManagement.dto.PassengerRequestDto;
import com.demo.ticketManagement.dto.PassengerResponseDto;

/**
 * @author 91970
 *
 */

public interface PassengerService {

	/**
	 * This method is used to add passengers to ticket
	 * @param passengerRequestDtoList
	 * @param ticketId
	 * @return PassengerResponseDto with message
	 */
	//PassengerResponseDto addPassengerDetails(List<PassengerRequestDto> passengerRequestDtoList, Long ticketId);

	/**
	 * This method is used to add passengerDetails 
	 * @param passengerRequestDtoList
	 * @param ticketId
	 * @return a string "passenger added successfully" if added 
	 */
	String addPassengerDetails1(List<PassengerRequestDto> passengerRequestDtoList, Long ticketId);

	/*
	 * This method is used to get all the ticket details 
	 */
	ItenaryResponseDto getItenary(Long ticketId);

	/**
	 * This method is used to get all the passengerDetails by ticketId
	 * @param ticketId
	 * @return passengersList
	 */
	List<PassengerDto> getPassengersByTicketId(Long ticketId);

}
