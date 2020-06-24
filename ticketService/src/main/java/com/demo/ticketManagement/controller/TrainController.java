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

import com.demo.ticketManagement.dto.SeatDetailsDto;
import com.demo.ticketManagement.dto.TrainRequestDto;
import com.demo.ticketManagement.service.TrainService;

/**
 * @author Suma
 *
 */
@RestController
public class TrainController {
	@Autowired
	TrainService trainService;
	@Autowired
	RestTemplate restTemplate;

	/**
	 * This method is used to get available trainDetails 
	 * @param trainRequestDto
	 * @return trainDetails list
	 */
	@PostMapping("/trains")
	public ResponseEntity<String> getTrainDetailsByLocation(@RequestBody TrainRequestDto trainRequestDto) {

		String trainScheduleDetails = trainService.getAllTrainsByLocation(trainRequestDto);
		return new ResponseEntity<String>(trainScheduleDetails, HttpStatus.OK);
	}

	/**
	 * This method is used to get seatDetails of a selected train
	 * @param trainScheduleId
	 * @return available seatdetails
	 */
	@GetMapping("/seats/{trainScheduleId}")
	public ResponseEntity<SeatDetailsDto> getSeatDetails(@PathVariable("trainScheduleId") Long trainScheduleId) {
		SeatDetailsDto seatDetailsDto = trainService.getAvailableSeats(trainScheduleId);
		return new ResponseEntity<SeatDetailsDto>(seatDetailsDto, HttpStatus.OK);
	}
}