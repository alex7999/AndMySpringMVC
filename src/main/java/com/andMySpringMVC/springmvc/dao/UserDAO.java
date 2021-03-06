package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
    User findByUsername(String username);
    List<Integer> getChildren(List<Integer> parent);
}
