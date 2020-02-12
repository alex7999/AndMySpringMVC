package com.andMySpringMVC.springmvc.model;

import javax.persistence.*;

@Entity(name = "sitName")
public class SitPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "row")
    private int row;

    @Column(name = "position")
    private int position;

    @Column(name = "hall")
    @OneToMany
    private Hall hall;
}
