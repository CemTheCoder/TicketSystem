package com.ticketmain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ticketmain.models.User;


@Repository
@Component
public interface UserDao2 extends JpaRepository<User, Integer>{

	
	public User findByEmail(String email);
	
	public User findById(int id);
}
