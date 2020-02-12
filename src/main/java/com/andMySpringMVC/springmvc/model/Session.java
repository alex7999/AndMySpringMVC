package com.andMySpringMVC.springmvc.model;

import javax.persistence.Entity;

@Entity
public class Session {

    private int id;
    private Films film;
    private Hall hall;

}
