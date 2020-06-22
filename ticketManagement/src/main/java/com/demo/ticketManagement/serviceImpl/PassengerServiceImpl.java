package com.demo.ticketManagement.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.ticketManagement.dao.PassengerDao;
import com.demo.ticketManagement.dao.TicketDao;
import com.demo.ticketManagement.dto.ItenaryResponseDto;
import com.demo.ticketManagement.dto.PassengerDto;
import com.demo.ticketManagement.dto.PassengerRequestDto;
import com.demo.ticketManagement.dto.PassengerResponseDto;
import com.demo.ticketManagement.dto.SeatDto;
import com.demo.ticketManagement.dto.TrainDetailsDto;
import com.demo.ticketManagement.dto.UserResponseDto;
import com.demo.ticketManagement.model.Passenger;
import com.demo.ticketManagement.model.Ticket;
import com.demo.ticketManagement.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	PassengerDao passengerDao;
	@Autowired
	TicketDao ticketDao;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	PassengerService passengerService;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public PassengerResponseDto addPassengerDetails(List<PassengerRequestDto> passengerRequestDtoList, Long ticketId) {

		passengerRequestDtoList.stream().map(passengerRequestDto -> addPassengers(passengerRequestDto, ticketId))
				.collect(Collectors.toList());
		PassengerResponseDto passengerResponseDto = new PassengerResponseDto();
		passengerResponseDto.setMessage("Passenger added succesfully!!!");
		return passengerResponseDto;
	}

	private Passenger addPassengers(PassengerRequestDto passengerRequestDto, Long ticketId) {
		Optional<Ticket> ticket = ticketDao.findById(ticketId);
		Long trainScheduleId = ticket.get().getTrainScheduleId();
		Passenger passenger = new Passenger();
		passenger.setAge(passengerRequestDto.getAge());
		passenger.setTicketId(ticketId);
		passenger.setPassengerName(passengerRequestDto.getPassengerName());
		passenger.setSeatType(passengerRequestDto.getSeatType());
		passengerDao.save(passenger);
		String url = "http://localhost:8083/seats/" + trainScheduleId;
		restTemplate.getForObject(url, PassengerResponseDto.class);
		return passenger;
	}
	
	private String addPassengers1(PassengerRequestDto passengerRequestDto, Long ticketId) {
		Optional<Ticket> ticket = ticketDao.findById(ticketId);
		Long trainScheduleId = ticket.get().getTrainScheduleId();
		Passenger passenger = new Passenger();
		passenger.setAge(passengerRequestDto.getAge());
		passenger.setTicketId(ticketId);
		passenger.setPassengerName(passengerRequestDto.getPassengerName());
		passenger.setSeatType(passengerRequestDto.getSeatType());
		passengerDao.save(passenger);
		String url = "http://localhost:8083/seats/" + trainScheduleId;
		restTemplate.getForObject(url, PassengerResponseDto.class);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		SeatDto seatDto = new SeatDto();
		seatDto.setSeatType(passengerRequestDto.getSeatType());
		seatDto.setTrainScheduleId(trainScheduleId);
		HttpEntity<SeatDto> entity = new HttpEntity<SeatDto>(seatDto, headers);
		return restTemplate
				.exchange("http://localhost:8083/seats/" + trainScheduleId, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String addPassengerDetails1(List<PassengerRequestDto> passengerRequestDtoList, Long ticketId) {
		passengerRequestDtoList.stream().map(passengerRequestDto -> addPassengers1(passengerRequestDto, ticketId))
				.collect(Collectors.toList());
		PassengerResponseDto passengerResponseDto = new PassengerResponseDto();
		passengerResponseDto.setMessage("Passenger added succesfully!!!");
		return "passengers added successfully";

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItenaryResponseDto getItenary(Long ticketId) {
		Optional<Ticket> ticket = ticketDao.findById(ticketId);
		Long userId = ticket.get().getUserId();
		Long trainScheduleId = ticket.get().getTrainScheduleId();
		/*
		 * To get the userDetails by userId from userManagament Application
		 */
		String url = "http://localhost:8082/users/" + userId;
		ItenaryResponseDto itenaryResponseDto = new ItenaryResponseDto();
		UserResponseDto userResponseDto = restTemplate.getForObject(url, UserResponseDto.class);
		/*
		 * To get the trainScheduleDetails by trainScheduleId from trainManagement
		 * Application
		 */

		String url1 = "http://localhost:8083/trainSchedules/" + trainScheduleId;
		TrainDetailsDto responseDto = restTemplate.getForObject(url1, TrainDetailsDto.class);
		BeanUtils.copyProperties(responseDto, itenaryResponseDto);
		Long trainId = responseDto.getTrainId();
		/*
		 * To get the trainDetails by trainId from trainManagement Application
		 */
		String url2 = "http://localhost:8083/trains/" + trainId;
		itenaryResponseDto = restTemplate.getForObject(url2, ItenaryResponseDto.class);
		System.out.println(itenaryResponseDto.getFromLocation());
		itenaryResponseDto.setPassengerDtoList(passengerService.getPassengersByTicketId(ticketId));
		BeanUtils.copyProperties(responseDto, itenaryResponseDto);
		BeanUtils.copyProperties(userResponseDto, itenaryResponseDto);
		return itenaryResponseDto;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PassengerDto> getPassengersByTicketId(Long ticketId) {
		List<PassengerDto> passengerDtoList = new ArrayList<>();
		Optional<List<Passenger>> passengerList = passengerDao.findAllByTicketId(ticketId);
		if (passengerList.isPresent()) {
			passengerList.get().stream().map(passenger -> getPassengerDto(passenger)).collect(Collectors.toList());
			passengerDtoList = passengerList.get().stream().map(passenger -> getPassengerDto(passenger))
					.collect(Collectors.toList());
			return passengerDtoList;
		} else
			return passengerDtoList;
	}

	private PassengerDto getPassengerDto(Passenger passenger) {
		PassengerDto passengerDto = new PassengerDto();
		BeanUtils.copyProperties(passenger, passengerDto);
		return passengerDto;
	}

}