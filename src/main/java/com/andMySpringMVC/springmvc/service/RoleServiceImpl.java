package com.andMySpringMVC.springmvc.service;


import com.andMySpringMVC.springmvc.dao.RoleDAO;
import com.andMySpringMVC.springmvc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Role> allRoles() {

        return roleDAO.allRoles();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        roleDAO.delete(role);

    }

    @Override
    @Transactional
    public void edit(Role role) {
        roleDAO.edit(role);
    }

    @Override
    @Transactional
    public Role getById(int id) {
        return roleDAO.getById(id);
    }
}
