package com.demo.ticketManagement.serviceImpl;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
		TrainDetailsDto trainDetailsDto = ticketService.getTrainDetails(trainScheduleId);
		ticketDto.setArrivalDate(trainDetailsDto.getArrivalDate());
		BeanUtils.copyProperties(trainDetailsDto, ticketDto);
		Ticket ticket = new Ticket();
		ticket.setUserId(userId);
		ticket.setTrainScheduleId(trainScheduleId);
		ticketDao.save(ticket);
		BeanUtils.copyProperties(ticket, ticketDto);
		ticketDto.setTicketId(ticket.getTicketId());
		ticketDto.setMessage("Please add passenger Details");
		Long trainId = trainDetailsDto.getTrainId();
		String url1 = "http://localhost:8083/trains/" + trainId;
		LocationDetailsDto responseDto = restTemplate.getForObject(url1, LocationDetailsDto.class);
		BeanUtils.copyProperties(responseDto, ticketDto);
		return ticketDto;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TrainDetailsDto getTrainDetails(Long trainScheduleId) {
		String url = "http://localhost:8083/trainSchedules/" + trainScheduleId;
		TrainDetailsDto responseDto = restTemplate.getForObject(url, TrainDetailsDto.class);
		return responseDto;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String authenticateUser(LoginRequestDto loginRequestDto) throws InvalidCredentialsException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<LoginRequestDto> entity = new HttpEntity<LoginRequestDto>(loginRequestDto, headers);
		return restTemplate.exchange("http://localhost:8082/users/login", HttpMethod.POST, entity, String.class)
				.getBody();
	}

}
