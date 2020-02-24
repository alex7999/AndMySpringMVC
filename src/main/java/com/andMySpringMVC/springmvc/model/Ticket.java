package com.andMySpringMVC.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @ManyToOne()
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private SessionFilm sessionFilm;

    @ManyToOne()
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SessionFilm getSessionFilm() {
        return sessionFilm;
    }

    public void setSessionFilm(SessionFilm sessionFilm) {
        this.sessionFilm = sessionFilm;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
