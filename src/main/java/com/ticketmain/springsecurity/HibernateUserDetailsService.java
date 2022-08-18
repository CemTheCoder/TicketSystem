package com.ticketmain.springsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ticketmain.dao.UserDao2;
import com.ticketmain.models.User;


@Service
public class HibernateUserDetailsService implements UserDetailsService{
	@Autowired
	private UserDao2 repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User u = this.repo.findByEmail(email);
		if(u == null) {
			throw new UsernameNotFoundException(email);
		}
		return u;
	}

}
