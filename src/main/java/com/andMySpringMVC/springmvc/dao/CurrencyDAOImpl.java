package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Currency;
import com.andMySpringMVC.springmvc.model.SessionFilm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Currency> allCurrency() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Currency").list();
    }

    @Override
    public void add(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(currency);
    }

    @Override
    public void delete(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(currency);
    }

    @Override
    public void edit(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.update(currency);
    }

    @Override
    public Currency getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Currency.class, id);
    }

    @Override
    public Currency getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return (Currency) session.createQuery("from Currency c where c.name = '"+ name + "'").uniqueResult();
    }
}
