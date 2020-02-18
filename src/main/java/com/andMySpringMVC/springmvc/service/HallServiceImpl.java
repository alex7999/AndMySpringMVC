package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.HallDAO;
import com.andMySpringMVC.springmvc.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private HallDAO hallDAO;

    @Override
    @Transactional
    public List<Hall> allHalls() {
        return hallDAO.allHalls();
    }

    @Override
    @Transactional
    public void add(Hall hall) {
        hallDAO.add(hall);
    }

    @Override
    @Transactional
    public void delete(Hall hall) {
        hallDAO.delete(hall);
    }

    @Override
    @Transactional
    public void edit(Hall hall) {
        hallDAO.edit(hall);
    }

    @Override
    @Transactional
    public Hall getById(int id) {
        return hallDAO.getById(id);
    }

    @Override
    @Transactional
    public Hall getByName(String name) {
        return hallDAO.getByName(name);
    }
}
