package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Hall;
import com.andMySpringMVC.springmvc.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HallDAOImpl implements HallDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Hall> allHalls() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Hall").list();
    }

    @Override
    public void add(Hall hall) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hall);
    }

    @Override
    public void delete(Hall hall) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(hall);
    }

    @Override
    public void edit(Hall hall) {
        Session session = sessionFactory.getCurrentSession();
        session.update(hall);
    }

    @Override
    public Hall getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return  (Hall) session.get(Hall.class, id);
    }

    @Override
    public Hall getByName(String name) {
        String hql = "from Hall h where h.name = '" + name + "'";
        return (Hall) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
    }
}
