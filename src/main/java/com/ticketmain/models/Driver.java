package com.ticketmain.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "driver_name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@OneToMany(mappedBy = "driver" ,  orphanRemoval = true)
	private List<Bus> bus;
	
	
	
	
	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}
	
	public List<Bus> getBus() {
		return bus;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	

}
