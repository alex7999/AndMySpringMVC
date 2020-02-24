package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.SessionFilmDAO;
import com.andMySpringMVC.springmvc.model.SessionFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SessionFilmServiceImpl implements SessionFilmService{
    @Autowired
    private SessionFilmDAO sessionFilmDAO;

    @Override
    @Transactional
    public List<SessionFilm> allSession() {
        return sessionFilmDAO.allSession();
    }

    @Override
    @Transactional
    public void add(SessionFilm sessionFilm) {
        sessionFilmDAO.add(sessionFilm);
    }

    @Override
    @Transactional
    public void delete(SessionFilm sessionFilm) {
        sessionFilmDAO.delete(sessionFilm);
    }

    @Override
    @Transactional
    public void edit(SessionFilm sessionFilm) {
        sessionFilmDAO.edit(sessionFilm);
    }

    @Override
    @Transactional
    public SessionFilm getById(int id) {
        return sessionFilmDAO.getById(id);
    }

    @Override
    @Transactional
    public SessionFilm getByName(String name) {
        return sessionFilmDAO.getByName(name);
    }
}
