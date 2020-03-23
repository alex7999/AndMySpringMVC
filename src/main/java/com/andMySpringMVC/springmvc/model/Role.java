package com.andMySpringMVC.springmvc.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
//@Table(name = "role")
@DiscriminatorValue(value = "Role")
public class Role extends Dictionary implements GrantedAuthority {
    public Role() {
    }

    public Role(String name, int ext_id) {
        super(name, ext_id);
    }
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column
//    private String discriminator;
//
//    @Column
//    private String name;
//
//    @Column
//    private int ext_id;
//
//    public Role() {}
//
//    public Role(String discriminator, String name, int ext_id) {
//
//        this.discriminator = discriminator;
//        this.name = name;
//        this.ext_id = ext_id;

//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDiscriminator() {
//        return discriminator;
//    }
//
//    public void setDiscriminator(String discriminator) {
//        this.discriminator = discriminator;
//    };
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getExt_id() {
//        return ext_id;
//    }
//
//
//    public void setExt_id(int ext_id) {
//        this.ext_id = ext_id;
//    }

    @Override
    public String toString() {
        return super.toString() +
                ", discriminator='" + "Role";
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}