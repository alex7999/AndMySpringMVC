package com.andMySpringMVC.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Money")
public class Currency extends Dictionary{

}
