package com.andMySpringMVC.springmvc.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "qRow")
    private int qRow;

    @Column(name = "qPosition")
    private int qPosition;

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "hall", fetch=FetchType.EAGER)//fetch=FetchType.LAZY,
    private Set<Place> places = new HashSet<>();


    public Hall() {
    }

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

    public int getqRow() {
        return qRow;
    }

    public void setqRow(int qRow) {
        this.qRow = qRow;
    }

    public int getqPosition() {
        return qPosition;
    }

    public void setqPosition(int qPosition) {
        this.qPosition = qPosition;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
}
