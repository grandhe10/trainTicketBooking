package com.demo.trainManagement.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.trainManagement.model.Train;


public interface TrainDao extends CrudRepository<Train,Long> {

	Optional<Train> findTrainIdByFromLocationAndToLocation(String fromLocation, String toLocation);
	
	Optional<Train> findByTrainId(Long trainId);

	
	

	

	

}
