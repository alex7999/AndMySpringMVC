package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.*;

import java.util.List;

public interface TicketService {
    List<Ticket> allTickets();
    void add(Ticket ticket);
    void delete(Ticket ticket);
    void edit(Ticket ticket);
    Ticket getById(int id);
    Ticket buyTicket(int session_id, int row, int position);
    Ticket buyTicketUser(SessionFilm sessionFilm, Place place, User user);
    Money getPriceTicket(int session_id, int row, int position);
}
