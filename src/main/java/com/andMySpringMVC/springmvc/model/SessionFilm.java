package com.andMySpringMVC.springmvc.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "session")
public class SessionFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

//    @ManyToOne
//    @Column(name = "film_id")
//    private Film film;
//
//    @ManyToOne
//    @Column(name = "hall_id")
//    private Hall hall;

    @Column(name = "timeStart")
    private Timestamp timeStart;

    @Column(name = "timeFinish")
    private Timestamp timeFinish;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Film getFilm() {
//        return film;
//    }
//
//    public void setFilm(Film film) {
//        this.film = film;
//    }
//
//    public Hall getHall() {
//        return hall;
//    }
//
//    public void setHall(Hall hall) {
//        this.hall = hall;
//    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(Timestamp timeFinish) {
        this.timeFinish = timeFinish;
    }
}
