package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Film;
import com.andMySpringMVC.springmvc.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/film/list", method = RequestMethod.GET)
    public List<Film> allFilms(){
        return filmService.allFilm();
    }

    @RequestMapping(value = "/film/getById/{id}", method = RequestMethod.GET)
    public Film getById(@PathVariable int id){
        return filmService.getById(id);
    }

    @RequestMapping(value = "/film/getByName/{name}", method = RequestMethod.GET)
    public Film getByName(@PathVariable String name){
        return filmService.getByName(name);
    }

    @RequestMapping(value = "/film/add", method = RequestMethod.POST)
    public Film addFilm(@ModelAttribute Film film){
        filmService.add(film);
        return film;
    }

    @RequestMapping(value = "/film/edit", method = RequestMethod.PUT)
    public Film editFilm(@ModelAttribute Film film){
        filmService.edit(film);
        return film;
    }

    @RequestMapping(value = "/film/delete/{id}", method = RequestMethod.DELETE)
    public Film deletetFilm(@PathVariable int id){
        Film film = filmService.getById(id);
        filmService.delete(film);
        return film;
    }
}
