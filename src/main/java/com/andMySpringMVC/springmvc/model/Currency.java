package com.andMySpringMVC.springmvc.model;

import javax.persistence.*;

@Entity
//@Table(name = "currency")
@DiscriminatorValue(value = "Money")
public class Currency extends Dictionary {

    public Currency() {
    }
}
