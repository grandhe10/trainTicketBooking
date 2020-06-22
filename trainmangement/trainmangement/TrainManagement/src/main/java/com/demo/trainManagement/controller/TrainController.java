package com.demo.trainManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.trainManagement.dto.LocationDetailsDto;
import com.demo.trainManagement.dto.TrainDetailsDto;
import com.demo.trainManagement.dto.TrainRequestDto;
import com.demo.trainManagement.dto.TrainResponseDto;
import com.demo.trainManagement.exception.ResourceNotFoundException;
import com.demo.trainManagement.service.TrainService;
/**
 * @author haritha/monisha
 *
 */
@RestController
public class TrainController {
	@Autowired
	TrainService trainService;

	/**
	 * @param trainRequestDto
	 * @return all trains
	 */
	@PostMapping("/trains")
	public ResponseEntity<List<TrainResponseDto>> searchTrainDetails(@RequestBody TrainRequestDto trainRequestDto) {
		List<TrainResponseDto> trainResponse = trainService.searchTrainDetails(trainRequestDto);
		return new ResponseEntity<List<TrainResponseDto>>(trainResponse, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/seats/{trainScheduleId}") public
	 * ResponseEntity<SeatResponseDto> findAvailableSeatDetails(@PathVariable Long
	 * trainScheduleId) { SeatResponseDto seatResponseDto =
	 * trainService.findAvailableSeatDetails(trainScheduleId);
	 * if(seatResponseDto.getMessage().equalsIgnoreCase("no seat is available"))
	 * throw new
	 * ResourceNotFoundException("No seats are available at this moment",HttpStatus.
	 * NOT_FOUND); else return new ResponseEntity<SeatResponseDto>(seatResponseDto,
	 * HttpStatus.OK); }
	 */

	/**
	 * @param trainScheduleId
	 * @return train details based trainScheduleId
	 */
	@GetMapping("/trainSchedules/{trainScheduleId}")
	public ResponseEntity<TrainDetailsDto> getTrainDetails(@PathVariable("trainScheduleId") Long trainScheduleId) {
		TrainDetailsDto trainDetailsDto = trainService.getTrainDetails(trainScheduleId);
		if (trainDetailsDto.getMessage().equalsIgnoreCase("No details are found"))
			throw new ResourceNotFoundException("No details Found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<TrainDetailsDto>(trainDetailsDto, HttpStatus.OK);
	}
	/**
	 * @param trainId
	 * @return location details based trainScheduleId
	 */
	@GetMapping("/trains/{trainId}")
	public ResponseEntity<LocationDetailsDto> getLocationDetails(@PathVariable("trainId") long trainId)
	{
		LocationDetailsDto locationDetailsDto = trainService.getLocationDetails(trainId);
		if(locationDetailsDto.getMessage().equalsIgnoreCase("No details found!!"))
			throw new ResourceNotFoundException("No details found!!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<LocationDetailsDto>(locationDetailsDto,HttpStatus.OK);
	}
}
