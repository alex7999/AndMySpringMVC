package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.SessionFilm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SessionFilmDAOImpl implements SessionFilmDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SessionFilm> allSession() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SessionFilm").list();
    }

    @Override
    public void add(SessionFilm sessionFilm) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sessionFilm);
    }

    @Override
    public void delete(SessionFilm sessionFilm) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(sessionFilm);

    }

    @Override
    public void edit(SessionFilm sessionFilm) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sessionFilm);
    }

    @Override
    public SessionFilm getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(SessionFilm.class, id);
    }

    @Override
    public SessionFilm getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return (SessionFilm) session.createQuery("from SessionFilm s where s.name = '"+ name + "'").uniqueResult();
    }
}
