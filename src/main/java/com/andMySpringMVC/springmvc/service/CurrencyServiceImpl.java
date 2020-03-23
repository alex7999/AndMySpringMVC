package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.CurrencyDAO;
import com.andMySpringMVC.springmvc.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
//    @Qualifier("")
    @Autowired
    CurrencyDAO currencyDAO;
    
    @Override
    @Transactional
    public List<Currency> allCurrency() {
        return currencyDAO.allCurrency();
    }

    @Override
    @Transactional
    public void add(Currency currency) {
        currencyDAO.add(currency);
    }

    @Override
    @Transactional
    public void delete(Currency currency) {
        currencyDAO.delete(currency);
    }

    @Override
    @Transactional
    public void edit(Currency currency) {
        currencyDAO.edit(currency);
    }

    @Override
    @Transactional
    public Currency getById(int id) {
        return currencyDAO.getById(id);
    }

    @Override
    @Transactional
    public Currency getByName(String name) {
        return currencyDAO.getByName(name);
    }
}
