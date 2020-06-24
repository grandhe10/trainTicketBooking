package com.demo.trainManagement.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.trainManagement.model.Seats;


public interface SeatsDao extends CrudRepository<Seats,Long>{

	Optional<Seats> findAllByTrainScheduleId(Long trainScheduleId);
	
	Optional<Seats> findByGeneralAndTrainScheduleId(int seats,Long trainScheduleId);
	
	Optional<Seats> findBySleeperAndTrainScheduleId(int seats,Long trainScheduleId);
	
	Optional<Seats> findByThreeTierACAndTrainScheduleId(int seats,Long trainScheduleId);
	
	Optional<Seats> findByTwoTierACAndTrainScheduleId(int seats,Long trainScheduleId);

	Optional<Seats> findByTrainScheduleId(Long trainScheduleId);
	
	

}
