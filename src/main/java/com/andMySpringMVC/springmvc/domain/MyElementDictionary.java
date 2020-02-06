//package com.andMySpringMVC.springmvc.domain;
//
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "User")
//public class MyElementDictionary {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "discriminator")
//    private String discriminator;
//    @Column(name = "name")
//    private String name;
//    private int ext_id;
//
//    public MyElementDictionary(){
//
//    }
//
//    public MyElementDictionary(String discriminator, String name, int ext_id){
//        this.discriminator = discriminator;
//        this.name = name;
//        this.ext_id = ext_id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setExt_id(int ext_id) {
//        this.ext_id = ext_id;
//    }
//
//    public int getExt_id() {
//        return ext_id;
//    }
//
//    public void setDiscriminator(String discriminator){
//
//    }
//
//    public String getDiscriminator(){
//        return discriminator;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "MyElementDictionary{" +
//                "id=" + id +
//                ", discriminator='" + discriminator + '\'' +
//                ", name='" + name + '\'' +
//                ", ext_id=" + ext_id +
//                '}';
//    }
//}
