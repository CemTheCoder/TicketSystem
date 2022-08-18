package com.ticketmain.requests;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ticketmain.models.Bus;
import com.ticketmain.models.Ticket;

public class TripRequest {
	
	private String id;
	
	private String starting_date;
	
	private String destination;
	
	private String busid;
	
	private String trip_name;
	
	private String starting_spot;
	

	private String price;
	
	

	

	

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStarting_date() {
		return starting_date;
	}

	public void setStarting_date(String starting_date) {
		this.starting_date = starting_date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public String getTrip_name() {
		return trip_name;
	}

	public void setTrip_name(String trip_name) {
		this.trip_name = trip_name;
	}

	public String getStarting_spot() {
		return starting_spot;
	}

	public void setStarting_spot(String starting_spot) {
		this.starting_spot = starting_spot;
	}
	
	
	
	
	

}
