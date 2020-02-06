package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> allUser();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}
