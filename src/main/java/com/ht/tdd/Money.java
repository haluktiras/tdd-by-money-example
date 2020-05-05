package com.ht.tdd;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Money {
    protected BigDecimal amount;

    public abstract Money times(BigDecimal multiplier);

    public static Money dollar(BigDecimal amount) {
        return new Dollar(amount);
    }

    public static Money lira(BigDecimal amount) {
        return new Lira(amount);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return Objects.equals(amount, money.amount)
                && this.getClass().equals(object.getClass());
    }
}
