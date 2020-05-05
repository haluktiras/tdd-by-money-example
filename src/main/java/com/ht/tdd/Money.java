package com.ht.tdd;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    protected BigDecimal amount;
    protected String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(BigDecimal amount) {
        return new Dollar(amount, "USD");
    }

    public static Money lira(BigDecimal amount) {
        return new Lira(amount, "TRY");
    }

    public Money times(BigDecimal multiplier) {
        return new Money(amount.multiply(multiplier), this.currency);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return Objects.equals(amount, money.amount)
                && this.currency == money.currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
