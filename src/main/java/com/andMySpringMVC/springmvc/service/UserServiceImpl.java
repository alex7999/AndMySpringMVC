package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.UserDAO;
import com.andMySpringMVC.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

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

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Override
    @Transactional
    public User  findByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
