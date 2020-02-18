package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Place;
import com.andMySpringMVC.springmvc.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/place/list", method = RequestMethod.GET)
    public List<Place> allPlace(){
       return placeService.allPlace();
    }
}
