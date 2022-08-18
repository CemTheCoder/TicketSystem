package com.ticketmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@ComponentScan(basePackages = "com.ticketmain")
@EnableWebMvc
@EnableTransactionManagement
@EnableWebSecurity
@SpringBootApplication
@EnableJpaRepositories("com.ticketmain")
@EntityScan("com.ticketmain.models")
public class TicketmainApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TicketmainApplication.class, args);
	}

}
