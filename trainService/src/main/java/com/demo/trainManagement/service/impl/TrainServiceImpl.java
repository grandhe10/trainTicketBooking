package com.demo.trainManagement.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.trainManagement.dao.SeatsDao;
import com.demo.trainManagement.dao.TrainDao;
import com.demo.trainManagement.dao.TrainScheduleDao;
import com.demo.trainManagement.dto.LocationDetailsDto;
import com.demo.trainManagement.dto.SeatResponseDto;
import com.demo.trainManagement.dto.SeatUpdateRequestDto;
import com.demo.trainManagement.dto.SeatUpdateResponseDto;
import com.demo.trainManagement.dto.TrainDetailsDto;
import com.demo.trainManagement.dto.TrainRequestDto;
import com.demo.trainManagement.dto.TrainResponseDto;
import com.demo.trainManagement.model.SeatOptions;
import com.demo.trainManagement.model.Seats;
import com.demo.trainManagement.model.Train;
import com.demo.trainManagement.model.TrainSchedule;
import com.demo.trainManagement.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {
	@Autowired
	TrainDao traindao;
	@Autowired
	TrainScheduleDao trainScheduleDao;
	@Autowired
	SeatsDao seatsDao;
	

	@Override
	public List<TrainResponseDto> searchTrainDetails(TrainRequestDto trainRequestDto) {
		List<TrainResponseDto> trainResponseDtoList = new ArrayList<TrainResponseDto>();
		Optional<Train> train = traindao.findTrainIdByFromLocationAndToLocation(trainRequestDto.getFromLocation(),
				trainRequestDto.getToLocation());
		
		LocalDate date = LocalDate.parse(trainRequestDto.getDepartureDate());
	Optional<List<TrainSchedule>> trainScheduledetails = trainScheduleDao
				.findAllByTrainIdAndDepartureDate(train.get().getTrainId(), date);
		if (trainScheduledetails.isPresent()) {
			return trainScheduledetails.get().stream().map(trainSchedule -> getTrainResponseDto(trainSchedule))
					.collect(Collectors.toList());
		} else {
			return trainResponseDtoList;
		}


	}
	private TrainResponseDto getTrainResponseDto(TrainSchedule trainSchedule) {
		TrainResponseDto trainResponseDto = new TrainResponseDto();
		BeanUtils.copyProperties(trainSchedule, trainResponseDto);
		return trainResponseDto;
	}

	@Override
	public SeatResponseDto findAvailableSeatDetails(Long trainScheduleId) {
		SeatResponseDto seatResponseDto = new SeatResponseDto();
		Optional<Seats> seats = seatsDao.findAllByTrainScheduleId(trainScheduleId);
		if ((seats.get().getGeneral() < 5) && (seats.get().getSleeper()) <5 && (seats.get().getThreeTierAC()) <5 
				&& (seats.get().getTwoTierAC()) < 5)
			return new SeatResponseDto("no seat is available");
		else {

			BeanUtils.copyProperties(seats.get(), seatResponseDto);
			seatResponseDto.setMessage("The Seat details are here !!!");
			return seatResponseDto;
		}
	}

	@Override
	public TrainDetailsDto getTrainDetails(Long trainScheduleId) {
		Optional<TrainSchedule> trainSchedule = trainScheduleDao.findByTrainScheduleId(trainScheduleId);
		if (trainSchedule.isPresent()) {
			TrainDetailsDto trainDetailsDto = new TrainDetailsDto();
			trainDetailsDto.setMessage("Please find the below departure and arrival details");
			BeanUtils.copyProperties(trainSchedule.get(), trainDetailsDto);
			return trainDetailsDto;
		} else
			return new TrainDetailsDto("No details are found");
	}

	@Override
	public LocationDetailsDto getLocationDetails(Long trainId) {
		Optional<Train> train = traindao.findByTrainId(trainId);
		if (train.isPresent()) {
			LocationDetailsDto locationDetailsDto = new LocationDetailsDto();
			BeanUtils.copyProperties(train.get(), locationDetailsDto);
			locationDetailsDto.setMessage("Find the location details here!!");
			return locationDetailsDto;
		}
		return new LocationDetailsDto("No details found!!");
	}

	
}
