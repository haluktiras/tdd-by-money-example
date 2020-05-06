package com.ht.tdd;

import java.math.BigDecimal;
import java.util.Objects;

public class Money implements Expression{
    protected BigDecimal amount;
    protected String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(BigDecimal amount) {
        return new Money(amount, "USD");
    }

    public static Money lira(BigDecimal amount) {
        return new Money(amount, "TRY");
    }

    public Money times(BigDecimal multiplier) {
        return new Money(amount.multiply(multiplier), this.currency);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return Objects.equals(amount, money.amount)
                && Objects.equals(this.currency, money.currency);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount.divide(bank.rate(this.currency, to)), to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus(Money addend){
        return new Sum(this, addend);
    }
}
