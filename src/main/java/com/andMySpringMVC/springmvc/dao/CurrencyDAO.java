package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Currency;

import java.util.List;

public interface CurrencyDAO {
    List<Currency> allCurrency();
    void add(Currency currency);
    void delete(Currency currency);
    void edit(Currency currency);
    Currency getById(int id);
    Currency getByName(String name);
}
