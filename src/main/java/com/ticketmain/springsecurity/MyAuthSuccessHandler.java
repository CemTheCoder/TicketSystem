package com.ticketmain.springsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ticketmain.dao.UserDao2;
import com.ticketmain.models.User;

public class MyAuthSuccessHandler implements AuthenticationSuccessHandler{

	
	@Autowired
	private UserDao2 dao;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
	
		response.sendRedirect("profile");
		
		
		
		
	}
	
}