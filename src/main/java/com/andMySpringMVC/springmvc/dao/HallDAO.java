package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Hall;
import com.andMySpringMVC.springmvc.model.Role;

import java.util.List;

public interface HallDAO {

    List<Hall> allHalls();
    void add(Hall hall);
    void delete(Hall hall);
    void edit(Hall hall);
    Hall getById(int id);
    Hall getByName(String name);

}
