package com.ticketmain.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trips")
public class Trip {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "starting_date")
	private String starting_date;
	@Column(name = "destination")
	private String destination;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buses_id" , referencedColumnName = "id")
	private Bus buss;
	@OneToOne(mappedBy = "trip")
	private Ticket ticket;
	
	@Column(name = "trip_name")
	private String trip_name;
	@Column(name = "starting_spot")
	private String starting_spot;
	
	@Column(name = "busid")
	private int busid;
	
	
	@Column(name = "price")
	private int price;
	
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public String getStarting_spot() {
		return starting_spot;
	}
	public void setStarting_spot(String starting_spot) {
		this.starting_spot = starting_spot;
	}
	public String getTrip_name() {
		return trip_name;
	}
	public void setTrip_name(String trip_name) {
		this.trip_name = trip_name;
	}
	public Bus getBuss() {
		return buss;
	}
	public void setBuss(Bus buss) {
		this.buss = buss;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Bus getBus() {
		return buss;
	}
	public void setBus(Bus bus) {
		this.buss = bus;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	

}
