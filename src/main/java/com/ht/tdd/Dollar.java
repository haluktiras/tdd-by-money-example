package com.ht.tdd;

import java.math.BigDecimal;

public class Dollar extends Money {

    public Dollar(BigDecimal amount) {
        this.amount = amount;
    }

    public Money times(BigDecimal multiplier) {
        return new Dollar(amount.multiply(multiplier));
    }
}
