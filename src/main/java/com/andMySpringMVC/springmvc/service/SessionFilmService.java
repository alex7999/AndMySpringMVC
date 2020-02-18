package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.SessionFilm;

import java.util.List;

public interface SessionFilmService {
    List<SessionFilm> allSession();
    void add(SessionFilm sessionFilm);
    void delete(SessionFilm sessionFilm);
    void edit(SessionFilm sessionFilm);
    SessionFilm getById(int id);
    SessionFilm getByName(String name);
}
