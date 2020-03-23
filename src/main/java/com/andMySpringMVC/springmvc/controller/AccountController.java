package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Account;
import com.andMySpringMVC.springmvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account/list", method = RequestMethod.GET)
    public List<Account> allAccounts(){
        return accountService.allAccount();
    }

    @RequestMapping(value = "/account/add")
    public Account add(@ModelAttribute(name = "account") Account account){
        accountService.add(account);
        return account;
    }
}
