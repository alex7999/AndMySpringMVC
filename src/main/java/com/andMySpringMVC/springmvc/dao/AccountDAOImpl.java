package com.andMySpringMVC.springmvc.dao;

import com.andMySpringMVC.springmvc.model.Account;
import com.andMySpringMVC.springmvc.model.Money;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Account> allAccount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Account").list();
    }

    @Override
    public void add(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
    }

    @Override
    public void delete(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(account);
    }

    @Override
    public void edit(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.update(account);
    }

    @Override
    public Account getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, id);
    }

    @Override
    public boolean deposit(Account account, Money money) {
        Money moneyAccount = account.getMoney();
        if (money.getCurrency() == moneyAccount.getCurrency()){
            BigDecimal amount = moneyAccount.getAmount();
            amount = amount.add(money.getAmount());
            moneyAccount.setAmount(amount);
            account.setMoney(moneyAccount);
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(Account account, Money money) {
        Money moneyAccount = account.getMoney();
        if (money.getCurrency() == moneyAccount.getCurrency()){
            BigDecimal amount = moneyAccount.getAmount();
            amount = amount.subtract(money.getAmount());
            moneyAccount.setAmount(amount);
            account.setMoney(moneyAccount);
            return true;
        }
        return false;
    }

}
