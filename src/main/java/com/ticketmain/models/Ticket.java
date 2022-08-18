package com.ticketmain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "passenger_name")
	private String passengername;
	@Column(name = "passenger_surname")
	private String passengersurname;
	
	@Column(name = "ticket_purchase_time")
	private String purchasetime;
	
	@Column(name = "ticket_name")
	private String ticketname;
	
	
	@OneToOne
	@JoinColumn(name = "trip_id" , referencedColumnName = "id")
	private Trip trip;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id" , referencedColumnName = "id")
	private User user;
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Column(name = "tripid")
	private int tripid;
	
	
	@Column(name = "tripname")
	private String tripname;
	
	
	@Column(name = "ticket_price")
	private int price;
	
	
	@Column(name = "trip_date")
	private String tripdate;
	
	
	

	public String getTripdate() {
		return tripdate;
	}


	public void setTripdate(String tripdate) {
		this.tripdate = tripdate;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getTripname() {
		return tripname;
	}


	public void setTripname(String tripname) {
		this.tripname = tripname;
	}


	public int getTripid() {
		return tripid;
	}


	public void setTripid(int tripid) {
		this.tripid = tripid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	


	


	public String getPassengername() {
		return passengername;
	}


	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}


	public String getPassengersurname() {
		return passengersurname;
	}


	public void setPassengersurname(String passengersurname) {
		this.passengersurname = passengersurname;
	}


	public String getPurchasetime() {
		return purchasetime;
	}


	public void setPurchasetime(String purchasetime) {
		this.purchasetime = purchasetime;
	}


	


	public String getTicketname() {
		return ticketname;
	}


	public void setTicketname(String ticketname) {
		this.ticketname = ticketname;
	}


	public Trip getTrip() {
		return trip;
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
