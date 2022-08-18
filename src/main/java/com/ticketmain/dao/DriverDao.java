package com.ticketmain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ticketmain.models.Driver;


@Repository
@Component
public interface DriverDao extends JpaRepository<Driver, Integer> {
	
	
	
	
	public Driver findById(int id);
	
	

}
