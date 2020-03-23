package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.AccountDAO;
import com.andMySpringMVC.springmvc.model.Account;
import com.andMySpringMVC.springmvc.model.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO accountDAO;


    @Override
    @Transactional
    public List<Account> allAccount() {
        return accountDAO.allAccount();
    }

    @Override
    @Transactional
    public void add(Account account) {
        accountDAO.add(account);
    }

    @Override
    @Transactional
    public void delete(Account account) {
        accountDAO.delete(account);
    }

    @Override
    @Transactional
    public void edit(Account account) {
        accountDAO.edit(account);
    }

    @Override
    @Transactional
    public Account getById(int id) {
        return accountDAO.getById(id);
    }

    @Override
    public boolean deposit(Account account, Money money){
        return accountDAO.deposit(account, money);
    }

    @Override
    public boolean withdraw(Account account, Money money){
        return accountDAO.withdraw(account, money);
    }
}
