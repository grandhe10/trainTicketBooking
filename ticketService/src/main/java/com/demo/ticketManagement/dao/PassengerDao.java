package com.demo.ticketManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ticketManagement.model.Passenger;
@Repository
public interface PassengerDao extends CrudRepository<Passenger, Long>{
	
	/**
	 * This method is used to get passengerDetails by ticketId
	 * @param ticketId
	 * @return passengersList
	 */
	Optional<List<Passenger>> findAllByTicketId(Long ticketId);
	
	

}
