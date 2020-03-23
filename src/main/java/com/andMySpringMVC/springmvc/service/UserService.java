package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allUser();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
    User findByUsername(String username);
    User getCurrentUser();
    List<Integer> getChildren(List<Integer> parent);
}
