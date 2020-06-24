package com.demo.trainManagement.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.trainManagement.dao.SeatsDao;
import com.demo.trainManagement.dto.SeatUpdateRequestDto;
import com.demo.trainManagement.dto.SeatUpdateResponseDto;
import com.demo.trainManagement.model.SeatOptions;
import com.demo.trainManagement.model.Seats;
@ExtendWith(MockitoExtension.class)
public class SeatServiceImplTest {
	SeatsDao seatDao;
	Seats seats;
	SeatUpdateRequestDto seatUpdateRequestDto;
	@Mock
	SeatsDao seatsDao;
	
	@InjectMocks
	SeatServiceImpl seatServiceImpl;
	
	
	@BeforeEach
	public void setUp()
	{
		
		seatUpdateRequestDto = new SeatUpdateRequestDto();
		seatUpdateRequestDto.setSeatType(SeatOptions.GENERAL);
		seatUpdateRequestDto.setTrainScheduleId(1L);
	}
	@Test
	public void updateSeatBySeatTypeTest()
	{
		Seats seats = new Seats();
		seats.setGeneral(15);
		seats.setSeatId(1L);
		seats.setSleeper(15);
		seats.setThreeTierAC(15);
		seats.setTrainScheduleId(1L);
		seats.setTwoTierAC(15);
		
		SeatUpdateResponseDto seatUpdateResponseDto = new SeatUpdateResponseDto();
		seatUpdateResponseDto.setMessage("booking is confirmed");
		
		seatServiceImpl.updateSeatBySeatType(seatUpdateRequestDto);
		verify(seatsDao).findByTrainScheduleId(1L);	
	}
	
	
}
