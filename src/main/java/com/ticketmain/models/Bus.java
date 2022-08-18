package com.ticketmain.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bus")
public class Bus {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "capacity")
	private int capacity;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "driver_id", referencedColumnName = "id")
	private Driver driver;
	
	@NotNull
	@ManyToOne(optional = false ,fetch = FetchType.LAZY )
	@JoinColumn(name = "firm_id", referencedColumnName = "id" , nullable = false)
	private Firm firm;
	
	@OneToMany(mappedBy = "buss")
	private List<Trip> trips;	
	
	
	private int driverid;
	
	private int firmid;
	
	private String firmname;
	
	private String drivername;
	
	

	

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	public int getFirmid() {
		return firmid;
	}

	public void setFirmid(int firmid) {
		this.firmid = firmid;
	}

	public String getFirmname() {
		return firmname;
	}

	public void setFirmname(String firmname) {
		this.firmname = firmname;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}
	
	
	
}
