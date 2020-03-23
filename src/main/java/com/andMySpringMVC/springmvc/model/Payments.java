package com.andMySpringMVC.springmvc.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data")
    private LocalDateTime data;

    @Embedded
    private Money money;

    @ManyToOne
    @JoinColumn(name = "accountDT_id")
    private Account accountDT;

//    @Column(name = "accountCT_id")
    @ManyToOne
    @JoinColumn(name = "accountCT_id")
    private Account accountCT;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Account getAccountDT() {
        return accountDT;
    }

    public void setAccountDT(Account accountDT) {
        this.accountDT = accountDT;
    }

    public Account getAccountCT() {
        return accountCT;
    }

    public void setAccountCT(Account accountCT) {
        this.accountCT = accountCT;
    }
}
