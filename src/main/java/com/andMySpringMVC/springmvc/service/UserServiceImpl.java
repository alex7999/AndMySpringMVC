package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.UserDAO;
import com.andMySpringMVC.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> allUser() {
        return userDAO.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);

    }

    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);

    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
