package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Money;
import com.andMySpringMVC.springmvc.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

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

//    @Override
//    public BigDecimal getPrice(int session_id, int film_id, int place_id){
//        Session session = sessionFactory.getCurrentSession();
//        String TextQ = "select f.money.amount*p.coef*sf.coef as amount from Place as p, Film as f, SessionFilm as sf"
//        +" where sf.id = :session_id and f.id = :film_id and p.id = :place_id";
//
//        session.createQuery(TextQ);
//        Query query = session.createQuery(TextQ);
//        query.setParameter("session_id", session_id);
//        query.setParameter("film_id", film_id);
//        query.setParameter("place_id", place_id);
//
//        return (BigDecimal) query.uniqueResult();
//    }
}
