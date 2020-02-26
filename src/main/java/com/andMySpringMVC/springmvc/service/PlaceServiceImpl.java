package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.PlaceDAO;
import com.andMySpringMVC.springmvc.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceDAO placeDAO;

    @Transactional
    @Override
    public List<Place> allPlace() {
        return placeDAO.allPlace();
    }

    @Transactional
    @Override
    public void add(Place place) {
        placeDAO.add(place);
    }

    @Transactional
    @Override
    public void delete(Place place) {
        placeDAO.delete(place);
    }

    @Transactional
    @Override
    public void edit(Place place) {
        placeDAO.edit(place);

    }

    @Transactional
    @Override
    public Place getById(int id) {
        return placeDAO.getById(id);
    }

    @Transactional
    @Override
    public Place getByPlace(int hall_id, int row, int position) {
        return placeDAO.getByPlace(hall_id, row, position);
    }

}
