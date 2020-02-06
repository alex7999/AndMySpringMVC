package com.andMySpringMVC.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "dictionary")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator",
        discriminatorType = DiscriminatorType.STRING, length = 10)
public abstract class Dictionary  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int ext_id;

    public Dictionary() {
    }

    public Dictionary(String name, int ext_id) {
        this.name = name;
        this.ext_id = ext_id;
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

    public int getExt_id() {
        return ext_id;
    }

    public void setExt_id(int ext_id) {
        this.ext_id = ext_id;
    }
}
