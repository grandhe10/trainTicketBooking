package com.demo.trainManagement.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.trainManagement.dao.SeatsDao;
import com.demo.trainManagement.dao.TrainDao;
import com.demo.trainManagement.dao.TrainScheduleDao;
import com.demo.trainManagement.dto.SeatUpdateRequestDto;
import com.demo.trainManagement.dto.TrainDetailsDto;
import com.demo.trainManagement.dto.TrainRequestDto;
import com.demo.trainManagement.dto.TrainResponseDto;
import com.demo.trainManagement.model.SeatOptions;
import com.demo.trainManagement.model.Seats;
import com.demo.trainManagement.model.Train;
import com.demo.trainManagement.model.TrainSchedule;

@ExtendWith(MockitoExtension.class)

public class TrainServiceImplTest {
	SeatsDao seatDao;
	TrainRequestDto trainRequestDto;
	@Mock
	TrainDao trainDao;
	@Mock
	TrainScheduleDao trainScheduleDao;
	@Mock
	SeatsDao seatsDao;
	Seats seats;
	SeatUpdateRequestDto seatUpdateRequestDto;
	@InjectMocks
	TrainServiceImpl trainServiceImpl;
	@BeforeEach
	public void setUp()
	{
		trainRequestDto = new TrainRequestDto();
		trainRequestDto.setDepartureDate("2020-06-30");
		trainRequestDto.setFromLocation("Hyd");
		trainRequestDto.setToLocation("Blr");
		
		seatUpdateRequestDto = new SeatUpdateRequestDto();
		seatUpdateRequestDto.setSeatType(SeatOptions.GENERAL);
		seatUpdateRequestDto.setTrainScheduleId(1L);
		
		
	}
	
	@Test
	public void searchTrainDetailTest()
	{
	Train train = new Train();
	train.setFromLocation("Hyd");
	train.setToLocation("Chennai");
	train.setTrainId(1L);
	
	TrainSchedule trainSchedule  = new TrainSchedule();
	trainSchedule.setArrivalDate(LocalDate.parse("2020-06-30"));
	trainSchedule.setArrivalTime(LocalTime.parse("09:00:00"));
	trainSchedule.setDepartureDate(LocalDate.parse("2020-06-30"));
	trainSchedule.setDepartureTime(LocalTime.parse("02:00:00"));
	trainSchedule.setTrainId(1L);
	trainSchedule.setTrainNumber(1234L);
	trainSchedule.setTrainScheduleId(1L);
	List<TrainSchedule> trainScheduleList = new ArrayList<>();
	trainScheduleList.add(trainSchedule);
	List<TrainResponseDto> trainScheduleResponseList = new ArrayList<>();
	//trainScheduleList.add(trainSchedule);
	
	when(trainDao.findTrainIdByFromLocationAndToLocation("Hyd", "Blr")).thenReturn(Optional.of(train));
	when(trainScheduleDao.findAllByTrainIdAndDepartureDate(1L, LocalDate.parse("2020-06-30"))).thenReturn(Optional.of(trainScheduleList));
	trainScheduleResponseList = trainServiceImpl.searchTrainDetails(trainRequestDto);
	Assert.assertEquals(trainScheduleResponseList.get(0).getTrainNumber(), trainScheduleList.get(0).getTrainNumber());
	}
	
	/*
	 * @Test public void searchTrainDetailTest1() { Train train = new Train();
	 * train.setFromLocation("Hyd"); train.setToLocation("Chennai");
	 * train.setTrainId(1L);
	 * 
	 * TrainSchedule trainSchedule = new TrainSchedule();
	 * trainSchedule.setArrivalDate(LocalDate.parse("2020-06-30"));
	 * trainSchedule.setArrivalTime(LocalTime.parse("09:00:00"));
	 * trainSchedule.setDepartureDate(LocalDate.parse("2020-06-30"));
	 * trainSchedule.setDepartureTime(LocalTime.parse("02:00:00"));
	 * trainSchedule.setTrainId(1L); trainSchedule.setTrainNumber(1234L);
	 * trainSchedule.setTrainScheduleId(1L); List<TrainSchedule> trainScheduleList =
	 * new ArrayList<>();
	 * 
	 * List<TrainResponseDto> trainScheduleResponseList = new ArrayList<>();
	 * 
	 * 
	 * when(trainDao.findTrainIdByFromLocationAndToLocation("Hyd",
	 * "Blr")).thenReturn(Optional.of(train));
	 * when(trainScheduleDao.findAllByTrainIdAndDepartureDate(1L,
	 * LocalDate.parse("2020-06-30"))).thenReturn(Optional.of(trainScheduleList));
	 * when(trainServiceImpl.searchTrainDetails(trainRequestDto)).thenReturn(
	 * trainScheduleResponseList);
	 * verify(trainScheduleDao).findAllByTrainIdAndDepartureDate(1L,LocalDate.parse(
	 * "2020-06-30")); Assert.assertEquals(trainScheduleResponseList,
	 * trainScheduleList); }
	 */
	
	@Test
	public void findAvailableSeatDetailsTest()
	{
		TrainSchedule trainSchedule  = new TrainSchedule();
		trainSchedule.setArrivalDate(LocalDate.parse("2020-06-30"));
		trainSchedule.setArrivalTime(LocalTime.parse("09:00:00"));
		trainSchedule.setDepartureDate(LocalDate.parse("2020-06-30"));
		trainSchedule.setDepartureTime(LocalTime.parse("02:00:00"));
		trainSchedule.setTrainId(1L);
		trainSchedule.setTrainNumber(1234L);
		trainSchedule.setTrainScheduleId(1L);
		
		Seats seats = new Seats();
		seats.setGeneral(15);
		seats.setSeatId(1L);
		seats.setSleeper(15);
		seats.setThreeTierAC(15);
		seats.setTrainScheduleId(1L);
		seats.setTwoTierAC(15);
		
		when(seatsDao.findAllByTrainScheduleId(1L)).thenReturn(Optional.of(seats));
		trainServiceImpl.findAvailableSeatDetails(1L);
		verify(seatsDao).findAllByTrainScheduleId(1L);	
	}
	
	@Test
	public void getTrainDetailsList()
	{
		TrainDetailsDto trainDetailsDto = new TrainDetailsDto();
		trainDetailsDto.setArrivalDate(LocalDate.parse("2020-06-30"));
		trainDetailsDto.setArrivalTime(LocalTime.parse("09:00:00"));
		trainDetailsDto.setDepartureDate(LocalDate.parse("2020-06-30"));
		trainDetailsDto.setDepartureTime(LocalTime.parse("09:00:00"));
		trainDetailsDto.setTrainId(1L);
		trainDetailsDto.setTrainNumber(1234L);
		
		TrainSchedule trainSchedule  = new TrainSchedule();
		trainSchedule.setArrivalDate(LocalDate.parse("2020-06-30"));
		trainSchedule.setArrivalTime(LocalTime.parse("09:00:00"));
		trainSchedule.setDepartureDate(LocalDate.parse("2020-06-30"));
		trainSchedule.setDepartureTime(LocalTime.parse("02:00:00"));
		trainSchedule.setTrainId(1L);
		trainSchedule.setTrainNumber(1234L);
		trainSchedule.setTrainScheduleId(1L);
		
		when(trainScheduleDao.findByTrainScheduleId(1L)).thenReturn(Optional.of(trainSchedule));
		trainDetailsDto = trainServiceImpl.getTrainDetails(1L);
		verify(trainScheduleDao).findByTrainScheduleId(1L);
		Assert.assertEquals(trainDetailsDto.getTrainNumber(), trainSchedule.getTrainNumber());
	}
	
	@Test
	public void getLocationDetails()
	{
		Train train = new Train();
		train.setFromLocation("Hyd");
		train.setToLocation("chennai");
		train.setTrainId(1L);
		
		when(trainDao.findByTrainId(1L)).thenReturn(Optional.of(train));
		trainServiceImpl.getLocationDetails(1L);
		verify(trainDao).findByTrainId(1L);
		Assert.assertEquals( trainServiceImpl.getLocationDetails(1L).getFromLocation(), train.getFromLocation());
	}
	
}
