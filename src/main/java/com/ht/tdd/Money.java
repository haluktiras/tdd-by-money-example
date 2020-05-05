package com.ht.tdd;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Money {
    protected BigDecimal amount;
    protected String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected abstract String currency();

    public abstract Money times(BigDecimal multiplier);

    public static Money dollar(BigDecimal amount) {
        return new Dollar(amount, "USD");
    }

    public static Money lira(BigDecimal amount) {
        return new Lira(amount, "TRY");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return Objects.equals(amount, money.amount)
                && this.getClass().equals(object.getClass());
    }
}
