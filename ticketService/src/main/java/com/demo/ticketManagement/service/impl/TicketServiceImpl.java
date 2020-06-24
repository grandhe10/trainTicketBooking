package com.demo.ticketManagement.service.impl;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.ticketManagement.dao.TicketDao;
import com.demo.ticketManagement.dto.LocationDetailsDto;
import com.demo.ticketManagement.dto.LoginRequestDto;
import com.demo.ticketManagement.dto.TicketDto;
import com.demo.ticketManagement.dto.TrainDetailsDto;
import com.demo.ticketManagement.exception.InvalidCredentialsException;
import com.demo.ticketManagement.model.Ticket;
import com.demo.ticketManagement.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	TicketDao ticketDao;
	@Autowired
	TicketService ticketService;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TicketDto bookTicket(Long userId, Long trainScheduleId) {
		TicketDto ticketDto = new TicketDto();
		
		Ticket ticket = new Ticket();
		
		ticket.setUserId(userId);
		ticket.setTrainScheduleId(trainScheduleId);
		ticketDao.save(ticket);
		String url = "http://TRAINSERVICE/trainSchedules/" + trainScheduleId;
		TrainDetailsDto trainDetailsDto = restTemplate.getForObject(url, TrainDetailsDto.class);
		//TrainDetailsDto trainDetailsDto = ticketService.getTrainDetails(trainScheduleId);
		
		BeanUtils.copyProperties(ticket, ticketDto);
		ticketDto.setMessage("Please add passenger Details");
	
		String url1 = "http://TRAINSERVICE/trains/" + trainDetailsDto.getTrainId();
		LocationDetailsDto responseDto = restTemplate.getForObject(url1, LocationDetailsDto.class);
		BeanUtils.copyProperties(responseDto, ticketDto);
		BeanUtils.copyProperties(trainDetailsDto, ticketDto);
		return ticketDto;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<String> authenticateUser(LoginRequestDto loginRequestDto) throws InvalidCredentialsException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<LoginRequestDto> entity = new HttpEntity<LoginRequestDto>(loginRequestDto, headers);
		return restTemplate.exchange("http://USERSERVICE/users/login", HttpMethod.POST, entity, String.class);
	}

	
}
