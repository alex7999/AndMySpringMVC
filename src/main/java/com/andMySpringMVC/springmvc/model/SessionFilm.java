package com.andMySpringMVC.springmvc.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessionfilm")
public class SessionFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "film_id",  referencedColumnName = "id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @Column(name = "timeStart")
    private LocalDateTime timeStart;

    @Column(name = "timeFinish")
    private LocalDateTime timeFinish;

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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(LocalDateTime timeFinish) {
        this.timeFinish = timeFinish;
    }
}
