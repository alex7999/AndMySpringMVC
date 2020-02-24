package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.AttributeOverride;
import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Ticket> allTickets() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Ticket").list();
    }

    @Override
    public void add(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(ticket);
    }

    @Override
    public void delete(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(ticket);
    }

    @Override
    public void edit(Ticket ticket) {

        Session session = sessionFactory.getCurrentSession();
        session.update(ticket);

    }

    @Override
    public Ticket getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Ticket.class, id);
    }
}
