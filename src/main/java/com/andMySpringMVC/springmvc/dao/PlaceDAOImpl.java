package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Hall;
import com.andMySpringMVC.springmvc.model.Place;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceDAOImpl implements PlaceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Place> allPlace() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Place").list();
    }

    @Override
    public void add(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.save(place);
    }

    @Override
    public void delete(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(place);
    }

    @Override
    public void edit(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.update(place);
    }

    @Override
    public Place getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Place) session.get(Place.class, id);
    }

    @Override
    public Place getByPlace(Hall hall_id, int nrow, int position) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Place p where p.hall = :hall_id AND p.position = :position AND p.nRow = :nrow";
        Query query = session.createQuery(hql);
        query.setParameter("hall_id", hall_id);
        query.setParameter("position", position);
        query.setParameter("nrow", nrow);
        return (Place) query.uniqueResult();
    }
}
