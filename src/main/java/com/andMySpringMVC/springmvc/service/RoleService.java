package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> allRoles();
    void add(Role role);
    void delete(Role role);
    void edit(Role role);
    Role getById(int id);
}