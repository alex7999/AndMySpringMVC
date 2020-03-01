package com.andMySpringMVC.springmvc.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Money {
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private Currency currency;
    private BigDecimal amount;
}
