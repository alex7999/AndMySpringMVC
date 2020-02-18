package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Hall;
import com.andMySpringMVC.springmvc.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HallController {
    @Autowired
    private HallService hallService;

    @RequestMapping(value = "/hall/list",method = RequestMethod.GET)
    public List<Hall> allHall(@ModelAttribute Hall hall){
        List<Hall> halls = hallService.allHalls();
        return halls;
    }

    @RequestMapping(value = "/hall/getById/{id}",method = RequestMethod.GET)
    public Hall getById(@PathVariable int id){
        return hallService.getById(id);
    }

    @RequestMapping(value = "/hall/add",method = RequestMethod.POST)
    public String addHall(@ModelAttribute Hall hall){
        hallService.add(hall);
        return hall.toString();
    }

    @RequestMapping(value = "/hall/delete/{id}",method = RequestMethod.DELETE)
    public Hall deleteHall(@PathVariable int id){
        Hall hallDell = hallService.getById(id);
        hallService.delete(hallDell);
        return hallDell;
    }

    @RequestMapping(value = "/hall/edit",method = RequestMethod.PUT)
    public Hall editHall(@ModelAttribute Hall hall){
//        Hall hallDell = hallService.getById(id);
        hallService.edit(hall);
        return hall;
    }
}
