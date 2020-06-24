package com.demo.trainManagement.service;

import com.demo.trainManagement.dto.SeatUpdateRequestDto;
import com.demo.trainManagement.dto.SeatUpdateResponseDto;

public interface SeatService {

	SeatUpdateResponseDto updateSeats(SeatUpdateRequestDto seatUpdateRequestDto);
	
	void updateSeatBySeatType(SeatUpdateRequestDto seatUpdateRequestDto);
}
