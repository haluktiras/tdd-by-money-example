package com.ht.tdd;

import java.math.BigDecimal;

public class Lira extends Money {

    public Lira(BigDecimal amount, String currency) {
        super(amount, currency);
    }

    @Override
    protected String currency() {
        return currency;
    }

    public Money times(BigDecimal multiplier) {
        return Money.lira(amount.multiply(multiplier));
    }
}
