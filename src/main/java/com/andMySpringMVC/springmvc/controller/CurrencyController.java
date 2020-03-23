package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Currency;
import com.andMySpringMVC.springmvc.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;


    @RequestMapping(value = "/currency/list", method = RequestMethod.GET)
    public List<Currency> allCurrency(){
        return currencyService.allCurrency();
    }

    @RequestMapping(value = "/currency/add", method = RequestMethod.POST)
    public Currency add(@ModelAttribute(name = "currency") Currency currency){
        currencyService.add(currency);
        return currency;
    }
}
