package com.demo.trainManagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.trainManagement.dao.SeatsDao;
import com.demo.trainManagement.dto.SeatUpdateRequestDto;
import com.demo.trainManagement.dto.SeatUpdateResponseDto;
import com.demo.trainManagement.model.SeatOptions;
import com.demo.trainManagement.model.Seats;
import com.demo.trainManagement.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {
	@Autowired
	SeatsDao seatsDao;

	@Override
	public void updateSeatBySeatType(SeatUpdateRequestDto seatUpdateRequestDto) {
		if (seatUpdateRequestDto.getSeatType().equals(SeatOptions.GENERAL)) {
			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				System.out.println(seat.get().getGeneral());
				seat.get().setGeneral(seat.get().getGeneral() - 1);
				seatsDao.save(seat.get());
			}
		}
		if (seatUpdateRequestDto.getSeatType().equals(SeatOptions.SLEEPER)) {

			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				seat.get().setSleeper(seat.get().getSleeper() - 1);
				seatsDao.save(seat.get());
			}
		}
		if (seatUpdateRequestDto.getSeatType().equals(SeatOptions.THREETIERAC)) {

			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				seat.get().setThreeTierAC(seat.get().getThreeTierAC() - 1);
				seatsDao.save(seat.get());
			}
		}
		if (seatUpdateRequestDto.getSeatType().equals(SeatOptions.TWOTIERAC)) {

			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				seat.get().setTwoTierAC(seat.get().getTwoTierAC() - 1);
				seatsDao.save(seat.get());
			}
		}
	}

	@Override
	public SeatUpdateResponseDto updateSeats(SeatUpdateRequestDto seatUpdateRequestDto) {
		if (seatUpdateRequestDto.getSeatType().equals(SeatOptions.GENERAL)) {

			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				if (seat.get().getGeneral() > 5) {
					seat.get().setGeneral(seat.get().getGeneral() - 1);
					seatsDao.save(seat.get());
					return new SeatUpdateResponseDto("booking is confirmed");
				}
				return new SeatUpdateResponseDto("seats unavailable");
			} else
				return new SeatUpdateResponseDto("seats unavailable");
		}

		else if (seatUpdateRequestDto.getSeatType().equals(SeatOptions.SLEEPER)) {

			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				if (seat.get().getGeneral() > 5) {
					seat.get().setSleeper(seat.get().getSleeper() - 1);
					seatsDao.save(seat.get());
					return new SeatUpdateResponseDto("booking is confirmed");
				}
				return new SeatUpdateResponseDto("seats unavailable");
			} else
				return new SeatUpdateResponseDto("seats unavailable");
		}

		else if (seatUpdateRequestDto.getSeatType().equals(SeatOptions.THREETIERAC)) {

			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				if (seat.get().getThreeTierAC() > 5) {
					seat.get().setThreeTierAC(seat.get().getThreeTierAC() - 1);
					seatsDao.save(seat.get());
					return new SeatUpdateResponseDto("booking is confirmed");
				}
				return new SeatUpdateResponseDto("seats unavailable");
			} else
				return new SeatUpdateResponseDto("seats unavailable");
		}

		else {

			Optional<Seats> seat = seatsDao.findByTrainScheduleId(seatUpdateRequestDto.getTrainScheduleId());
			if (seat.isPresent()) {
				if (seat.get().getTwoTierAC() > 5) {
					seat.get().setTwoTierAC(seat.get().getTwoTierAC() - 1);
					seatsDao.save(seat.get());
					return new SeatUpdateResponseDto("booking is confirmed");
				}
				return new SeatUpdateResponseDto("seats unavailable");
			} else
				return new SeatUpdateResponseDto("seats unavailable");
		}

	}

}
