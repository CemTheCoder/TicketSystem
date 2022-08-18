package com.ticketmain.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketmain.models.Firm;

public interface FirmDao extends JpaRepository<Firm, Integer> {
	

public Firm findById(int id);	
}
