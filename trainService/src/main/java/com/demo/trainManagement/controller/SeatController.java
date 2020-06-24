package com.demo.trainManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.trainManagement.dto.SeatResponseDto;
import com.demo.trainManagement.dto.SeatUpdateRequestDto;
import com.demo.trainManagement.exception.ResourceNotFoundException;
import com.demo.trainManagement.service.SeatService;
import com.demo.trainManagement.service.TrainService;
@RestController
public class SeatController {
@Autowired
TrainService trainService;
@Autowired
SeatService seatService;
	
	/**
	 * This method is used to get available seat details of a particular train
	 * @param trainScheduleId
	 * @return
	 */
	@GetMapping("/seats/{trainScheduleId}")
	public ResponseEntity<SeatResponseDto> findAvailableSeatDetails(@PathVariable Long trainScheduleId) {
		SeatResponseDto seatResponseDto = trainService.findAvailableSeatDetails(trainScheduleId);
		if(seatResponseDto.getMessage().equalsIgnoreCase("no seat is available"))
			throw new ResourceNotFoundException("No seats are available at this moment",HttpStatus.NOT_FOUND);
		else 
		return new ResponseEntity<SeatResponseDto>(seatResponseDto, HttpStatus.OK);
	}
	
	/**
	 * This method is used to update seat details 
	 * @param seatUpdateRequestDto
	 * @return
	 */
	@PutMapping("/seats/{trainScheduleId}")
	public ResponseEntity<String> updateSeatDetailsBySeatType(@RequestBody SeatUpdateRequestDto seatUpdateRequestDto)
	{
			seatService.updateSeatBySeatType(seatUpdateRequestDto);
		return new ResponseEntity<String>("Seat details updated",HttpStatus.OK);
	}
}