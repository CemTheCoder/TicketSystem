package com.ticketmain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticketmain.models.Bus;

public interface BusDao extends JpaRepository<Bus, Integer> {
	
	
	
}
