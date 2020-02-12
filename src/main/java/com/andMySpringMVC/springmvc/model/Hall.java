package com.andMySpringMVC.springmvc.model;

import javax.persistence.*;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "qSit")
    private int qSit;

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

    public int getqSit() {
        return qSit;
    }

    public void setqSit(int qSit) {
        this.qSit = qSit;
    }
}
