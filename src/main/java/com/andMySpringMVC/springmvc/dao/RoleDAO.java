package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> allRoles();
    void add(Role role);
    void delete(Role role);
    void edit(Role role);
    Role getById(int id);
    Role getByName(String name);
}
