package com.demo.ticketManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.ticketManagement.dto.SeatDetailsDto;
import com.demo.ticketManagement.dto.TrainRequestDto;
import com.demo.ticketManagement.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {
	@Autowired
	RestTemplate restTemplate;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAllTrainsByLocation(TrainRequestDto trainRequestDto) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<TrainRequestDto> httpEntity = new HttpEntity<>(trainRequestDto, headers);

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange("http://localhost:8083/trains", HttpMethod.POST, httpEntity, String.class)
				.getBody();

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SeatDetailsDto getAvailableSeats(Long trainScheduleId) {

		String url = "http://localhost:8083/seats/" + trainScheduleId;
		SeatDetailsDto responseDto = restTemplate.getForObject(url, SeatDetailsDto.class);
		return responseDto;
	}
}
