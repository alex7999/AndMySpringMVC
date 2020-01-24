package com.andMySpringMVC.springmvc.domain;

public class MyElementDictionary {
    private int id;
    private String discriminator;
    private String name;
    private int ext_id;

    public MyElementDictionary(){

    }

    public MyElementDictionary(String discriminator, String name){
        this.discriminator = discriminator;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setExt_id(int ext_id) {
        this.ext_id = ext_id;
    }

    public int getExt_id() {
        return ext_id;
    }

    public void setDiscriminator(String discriminator){

    }

    public String getDiscriminator(){
        return discriminator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyElementDictionary{" +
                "id=" + id +
                ", discriminator='" + discriminator + '\'' +
                ", name='" + name + '\'' +
                ", ext_id=" + ext_id +
                '}';
    }
}
