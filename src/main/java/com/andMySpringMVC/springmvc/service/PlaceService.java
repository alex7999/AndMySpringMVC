package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.Place;

import java.util.List;

public interface PlaceService {
    List<Place> allPlace();
    void add(Place place);
    void delete(Place place);
    void edit(Place place);
    Place getById(int id);
}
