package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.Payments;

import java.util.List;

public interface PaymentsService {
    List<Payments> allPayments();
    boolean add(Payments payments);
    void delete(Payments payments);
    void edit(Payments payments);
    Payments getById(int id);
}
