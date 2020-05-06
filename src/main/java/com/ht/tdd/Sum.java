package com.ht.tdd;

import java.math.BigDecimal;

public class Sum implements Expression {

    Expression augmend;
    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        BigDecimal amount = augmend.reduce(bank, to).amount.add(addmend.reduce(bank, to).amount);
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }

}
