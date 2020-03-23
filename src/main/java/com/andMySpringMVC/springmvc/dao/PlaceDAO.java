package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Hall;
import com.andMySpringMVC.springmvc.model.Place;

import java.util.List;

public interface PlaceDAO {
    List<Place> allPlace();
    void add(Place place);
    void delete(Place place);
    void edit(Place place);
    Place getById(int id);
    Place getByPlace(Hall hall_id, int row, int position);
}
