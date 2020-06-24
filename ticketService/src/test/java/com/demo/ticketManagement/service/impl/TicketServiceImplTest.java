package com.demo.ticketManagement.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.ticketManagement.dao.TicketDao;
import com.demo.ticketManagement.dto.LocationDetailsDto;
import com.demo.ticketManagement.dto.LoginRequestDto;
import com.demo.ticketManagement.dto.TicketDto;
import com.demo.ticketManagement.dto.TrainDetailsDto;
import com.demo.ticketManagement.model.Ticket;
import com.demo.ticketManagement.service.TicketService;
@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {
	
	Ticket ticket;
	TrainDetailsDto trainDetailsDto;
	TicketDto ticketDto;
	LocationDetailsDto locationDetailsDto;
	@Mock
	TicketDao ticketDao;
	
	@InjectMocks
	TicketServiceImpl ticketServiceImpl;
	
	@Mock 
	TicketService ticketService;
	@Mock
	RestTemplate restTemplate;
	LoginRequestDto loginRequestDto ;
	@BeforeEach
	public void setUp()
	{
		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setPassword("suma");
		loginRequestDto.setUserName("suma");
		

	}

	@Test
	public void bookTicketTest()
	{	
		Long trainId = 1L;
		Long trainScheduleId = 1L;
		Long userId = 1L;
		
		ticket = new Ticket();
		ticket.setTicketId(1L);
		ticket.setTrainScheduleId(1L);
		ticket.setUserId(1L);
		
		trainDetailsDto = new TrainDetailsDto();
		trainDetailsDto.setArrivalDate(LocalDate.parse("2020-07-25"));
		trainDetailsDto.setArrivalTime(LocalTime.parse("09:00:00"));
		trainDetailsDto.setDepartureDate(LocalDate.parse("2020-07-25"));
		trainDetailsDto.setDepartureTime(LocalTime.parse("09:00:00"));
		trainDetailsDto.setTrainId(1L);
		trainDetailsDto.setTrainNumber(1234L);
		
		locationDetailsDto = new LocationDetailsDto();
		locationDetailsDto.setFromLocation("Hyd");
		locationDetailsDto.setToLocation("chennai");
		
		ticketDto = new TicketDto();
		ticketDto.setFromLocation("Hyd");
		ticketDto.setMessage("booked Successfully");
		ticketDto.setTicketId(1L);
		ticketDto.setToLocation("Chennai");
		ticketDto.setArrivalDate(LocalDate.parse("2020-07-25"));
		ticketDto.setArrivalTime(LocalTime.parse("09:00:00"));
		ticketDto.setDepartureDate(LocalDate.parse("2020-07-25"));
		ticketDto.setDepartureTime(LocalTime.parse("09:00:00"));
		
		
		when(restTemplate.getForObject("http://TRAINSERVICE/trainSchedules/"+ trainScheduleId, TrainDetailsDto.class)).thenReturn(trainDetailsDto);
		when(restTemplate.getForObject("http://TRAINSERVICE/trains/" + trainDetailsDto.getTrainId(), LocationDetailsDto.class)).thenReturn(locationDetailsDto);
		TicketDto ticketDto1 = ticketServiceImpl.bookTicket(1L, 1L);
		Assert.assertEquals(ticketDto1.getFromLocation(), ticketDto.getFromLocation());
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void authenticateUserTest()

	{
		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setPassword("suma");
		loginRequestDto.setUserName("suma");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<LoginRequestDto> entity = new HttpEntity<LoginRequestDto>(loginRequestDto, headers);
		
		lenient().when(restTemplate.exchange("http://USERSERVICE/users/login", HttpMethod.POST, entity, String.class))
				.thenReturn(any(ResponseEntity.class));

	}

}
