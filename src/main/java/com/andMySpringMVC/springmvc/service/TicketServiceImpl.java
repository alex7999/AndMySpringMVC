package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.TicketDAO;
import com.andMySpringMVC.springmvc.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDAO ticketDAO;

    @Override
    @Transactional
    public List<Ticket> allTickets() {
        return ticketDAO.allTickets();
    }

    @Override
    @Transactional
    public void add(Ticket ticket) {
        ticketDAO.add(ticket);
    }

    @Override
    @Transactional
    public void delete(Ticket ticket) {
        ticketDAO.delete(ticket);
    }

    @Override
    @Transactional
    public void edit(Ticket ticket) {
        ticketDAO.edit(ticket);
    }

    @Override
    @Transactional
    public Ticket getById(int id) {
        return ticketDAO.getById(id);
    }
}
