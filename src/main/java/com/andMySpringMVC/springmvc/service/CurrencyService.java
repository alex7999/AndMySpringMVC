package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> allCurrency();
    void add(Currency currency);
    void delete(Currency currency);
    void edit(Currency currency);
    Currency getById(int id);
    Currency getByName(String name);
}
