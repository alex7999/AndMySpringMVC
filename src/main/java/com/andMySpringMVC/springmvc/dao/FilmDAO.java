package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Film;

import java.util.List;

public interface FilmDAO {
    List<Film> allFilm();
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
    Film getByName(String name);
}
