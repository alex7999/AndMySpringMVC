package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Payments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentsDAOImpl implements PaymentsDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Payments> allPayments() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Payments").list();
    }

    @Override
    public boolean add(Payments payments) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(payments);
        return true;
    }

    @Override
    public void delete(Payments payments) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(payments);
    }

    @Override
    public void edit(Payments payments) {
        Session session = sessionFactory.getCurrentSession();
        session.update(payments);
    }

    @Override
    public Payments getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Payments.class, id);
    }
}
