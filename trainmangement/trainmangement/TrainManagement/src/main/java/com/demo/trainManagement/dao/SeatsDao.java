package com.demo.trainManagement.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.trainManagement.model.Seats;


/**
 * @author monisha/haritha
 *
 */
public interface SeatsDao extends CrudRepository<Seats,Long>{

	/**
	 * @param trainScheduleId
	 * @return all trains by trainScheduleid
	 */
	Optional<Seats> findAllByTrainScheduleId(Long trainScheduleId);
	
	/**
	 * @param seats
	 * @param trainScheduleId
	 * @return update general seats by trainScheduleid
	 */
	Optional<Seats> findByGeneralAndTrainScheduleId(int seats,Long trainScheduleId);
	
	/**
	 * @param seats
	 * @param trainScheduleId
	 * @return update sleeper seats by trainScheduleid
	 */
	Optional<Seats> findBySleeperAndTrainScheduleId(int seats,Long trainScheduleId);
	/**
	 * @param seats
	 * @param trainScheduleId
	 * @return update three tier AC seats by trainScheduleid
	 */
	Optional<Seats> findByThreeTierACAndTrainScheduleId(int seats,Long trainScheduleId);
	/**
	 * @param seats
	 * @param trainScheduleId
	 * @return update two tier Ac seats by trainScheduleid
	 */
	Optional<Seats> findByTwoTierACAndTrainScheduleId(int seats,Long trainScheduleId);
	/**
	 * @param seats
	 * @param trainScheduleId
	 * @return update  seats by trainScheduleid
	 */
	Optional<Seats> findByTrainScheduleId(Long trainScheduleId);
	
	

}
