package com.demo.trainManagement.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.trainManagement.model.TrainSchedule;

public interface TrainScheduleDao extends CrudRepository<TrainSchedule,Long> {

	Optional<List<TrainSchedule>> findAllByTrainIdAndDepartureDate(Long trainId, LocalDate date);
	
	Optional<TrainSchedule> findByTrainScheduleId(Long trainScheduleId);

	

	

}
