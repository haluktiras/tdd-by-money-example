package com.ht.tdd;

import java.math.BigDecimal;

public class Lira extends Money {

    public Lira(BigDecimal amount) {
        this.amount = amount;
    }

    public Money times(BigDecimal multiplier) {
        return new Lira(amount.multiply(multiplier));
    }
}
