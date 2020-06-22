package com.demo.trainManagement.service;

import java.util.List;

import com.demo.trainManagement.dto.LocationDetailsDto;
import com.demo.trainManagement.dto.SeatResponseDto;
import com.demo.trainManagement.dto.SeatUpdateRequestDto;
import com.demo.trainManagement.dto.SeatUpdateResponseDto;
import com.demo.trainManagement.dto.TrainDetailsDto;
import com.demo.trainManagement.dto.TrainRequestDto;
import com.demo.trainManagement.dto.TrainResponseDto;
/**
 * @author monisha/haritha
 *
 */
public interface TrainService {

	List<TrainResponseDto> searchTrainDetails(TrainRequestDto trainRequestDto);

	SeatResponseDto findAvailableSeatDetails(Long trainScheduleId);

	TrainDetailsDto getTrainDetails(Long trainScheduleId);

	LocationDetailsDto getLocationDetails(Long trainId);

	SeatUpdateResponseDto updateSeats(SeatUpdateRequestDto seatUpdateRequestDto);
	
	

	

}
