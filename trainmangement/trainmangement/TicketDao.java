package com.demo.ticketManagement.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.demo.ticketManagement.model.Ticket;

/**
 * @author suma
 *
 */
@Repository
public interface TicketDao extends CrudRepository<Ticket, Long> {
	
	

}
