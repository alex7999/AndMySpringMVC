package com.andMySpringMVC.springmvc.model;

import javax.persistence.*;
import com.andMySpringMVC.springmvc.model.Role;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "name")
    private String name;

//    @Column(name = "role")
    @ManyToOne (optional=false)  //, cascade=CascadeType.ALL
    @JoinColumn (name="role")
    private Role role;

    public User() { }

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
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


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + role +
                '}';
    }
}
