package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Film;
import com.andMySpringMVC.springmvc.model.SessionFilm;
import com.andMySpringMVC.springmvc.service.FilmService;
import com.andMySpringMVC.springmvc.service.HallService;
import com.andMySpringMVC.springmvc.service.SessionFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionFilmController {
    @Autowired
    private SessionFilmService sessionFilmService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private HallService hallService;


    @RequestMapping(value = "/session/list", method = RequestMethod.GET)
    public List<SessionFilm> allSessinFilm(){
        return sessionFilmService.allSession();
    }

    @RequestMapping(value = "/session/getById/{id}", method = RequestMethod.GET)
    public SessionFilm getByIdSessinFilm(@PathVariable int id){

        return sessionFilmService.getById(id);
    }

    @RequestMapping(value = "/session/getByName/{name}", method = RequestMethod.GET)
    public SessionFilm getByIdSessinFilm(@PathVariable String name){

        return sessionFilmService.getByName(name);
    }

    @RequestMapping(value = "/session/add", method = RequestMethod.POST)
    public SessionFilm addSession(@ModelAttribute SessionFilm sessionFilm, int film_id, int hall_id, String timeStart, String timeFinish){
        sessionFilm.setFilm(filmService.getById(film_id));
        sessionFilm.setHall(hallService.getById(hall_id));
        sessionFilmService.add(sessionFilm);
        return sessionFilm;
    }

    @RequestMapping(value = "/session/edit", method = RequestMethod.PUT)
    public SessionFilm editSession(@ModelAttribute SessionFilm sessionFilm){
        sessionFilmService.edit(sessionFilm);
        return sessionFilm;
    }

    @RequestMapping(value = "/session/delete/{id}", method = RequestMethod.DELETE)
    public SessionFilm deleteSession(@PathVariable int id){
        SessionFilm sessionFilm = sessionFilmService.getById(id);
        sessionFilmService.delete(sessionFilm);
        return sessionFilm;
    }
}
