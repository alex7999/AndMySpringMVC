package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Account;
import com.andMySpringMVC.springmvc.model.Money;

import java.util.List;

public interface AccountDAO {
    List<Account> allAccount();
    void add(Account account);
    void delete(Account account);
    void edit(Account account);
    Account getById(int id);
    boolean deposit(Account account, Money money);
    boolean withdraw(Account account, Money money);
}
