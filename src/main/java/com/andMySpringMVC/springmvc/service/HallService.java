package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.Hall;

import java.util.List;

public interface HallService {
    List<Hall> allHalls();
    void add(Hall hall);
    void delete(Hall hall);
    void edit(Hall hall);
    Hall getById(int id);
    Hall getByName(String name);
}
