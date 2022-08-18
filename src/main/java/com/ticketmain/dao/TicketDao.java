package com.ticketmain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketmain.models.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer>{

}
