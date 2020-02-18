package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.FilmDAO;
import com.andMySpringMVC.springmvc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmDAO filmDAO;

    @Transactional
    @Override
    public List<Film> allFilm() {
        return filmDAO.allFilm();
    }

    @Transactional
    @Override
    public void add(Film film) {
        filmDAO.add(film);
    }

    @Transactional
    @Override
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    @Transactional
    @Override
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    @Transactional
    @Override
    public Film getById(int id) {
        return filmDAO.getById(id);
    }

    @Transactional
    @Override
    public Film getByName(String name) {
        return filmDAO.getByName(name);
    }
}
