package com.ticketmain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketmain.models.CreditCard;

public interface CreditCardDao extends JpaRepository<CreditCard, Integer> {

}
