package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Film> allFilm() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film").list();
    }

    @Override
    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.save(film);
    }

    @Override
    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getById(int id) {
        Session session =sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }

    @Override
    public Film getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return (Film) session.createQuery("from Film f where f.name = '"+ name + "'").uniqueResult();
    }
}
