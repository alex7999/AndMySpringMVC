package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.SessionFilm;

import java.util.List;

public interface SessionFilmDAO {
    List<SessionFilm> allSession();
    void add(SessionFilm sessionFilm);
    void delete(SessionFilm sessionFilm);
    void edit(SessionFilm sessionFilm);
    SessionFilm getById(int id);
    SessionFilm getByName(String name);
}
