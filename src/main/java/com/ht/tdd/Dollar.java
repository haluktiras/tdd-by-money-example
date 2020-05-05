package com.ht.tdd;

import java.math.BigDecimal;

public class Dollar extends Money {

    public Dollar(BigDecimal amount, String currency) {
        super(amount, currency);
    }

    @Override
    protected String currency() {
        return currency;
    }

    public Money times(BigDecimal multiplier) {
        return Money.dollar(amount.multiply(multiplier));
    }
}
