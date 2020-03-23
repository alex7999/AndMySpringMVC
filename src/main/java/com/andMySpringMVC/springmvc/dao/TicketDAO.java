package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Ticket;

import java.math.BigDecimal;
import java.util.List;

public interface TicketDAO {
    List<Ticket> allTickets();
    void add(Ticket ticket);
    void delete(Ticket ticket);
    void edit(Ticket ticket);
    Ticket getById(int id);
//    BigDecimal getPrice(int session_id, int film_id, int place_id);
}
