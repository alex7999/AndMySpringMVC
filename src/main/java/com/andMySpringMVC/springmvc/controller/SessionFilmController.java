package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.SessionFilm;
import com.andMySpringMVC.springmvc.service.SessionFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionFilmController {
    @Autowired
    private SessionFilmService sessionFilmService;

    @RequestMapping(value = "/session/list", method = RequestMethod.GET)
    public List<SessionFilm> allSessinFilm(){
        return sessionFilmService.allSession();
    }
}
