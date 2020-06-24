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

@RestController
public class TrainController {
	@Autowired
	TrainService trainService;

	@PostMapping("/trains")
	public ResponseEntity<List<TrainResponseDto>> searchTrainDetails(@RequestBody TrainRequestDto trainRequestDto) {
		List<TrainResponseDto> trainResponse = trainService.searchTrainDetails(trainRequestDto);
		return new ResponseEntity<List<TrainResponseDto>>(trainResponse, HttpStatus.OK);
	}

	@GetMapping("/trainSchedules/{trainScheduleId}")
	public ResponseEntity<TrainDetailsDto> getTrainDetails(@PathVariable("trainScheduleId") Long trainScheduleId) {
		TrainDetailsDto trainDetailsDto = trainService.getTrainDetails(trainScheduleId);
		if (trainDetailsDto.getMessage().equalsIgnoreCase("No details are found"))
			throw new ResourceNotFoundException("No details Found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<TrainDetailsDto>(trainDetailsDto, HttpStatus.OK);
	}
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
