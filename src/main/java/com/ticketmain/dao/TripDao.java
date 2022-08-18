package com.ticketmain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketmain.models.Trip;

public interface TripDao extends JpaRepository<Trip, Integer> {


}
