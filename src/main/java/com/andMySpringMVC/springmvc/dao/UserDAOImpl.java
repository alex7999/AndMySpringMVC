package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO, Serializable {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from User ").list();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        session.save(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        String hql = "from User u where u.username = '" + username + "'";
        return (User) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
    }

}
