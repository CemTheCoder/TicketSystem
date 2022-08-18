package com.ticketmain.requests;

import javax.persistence.Column;

public class TicketRequest {
	
	private String id;
	
	private String tripid;
	

	private String purchase_time;
	
	
	private String payment;
	
	
	


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTripid() {
		return tripid;
	}


	public void setTripid(String tripid) {
		this.tripid = tripid;
	}


	public String getPurchase_time() {
		return purchase_time;
	}


	public void setPurchase_time(String purchase_time) {
		this.purchase_time = purchase_time;
	}


	
	
	
	

}
