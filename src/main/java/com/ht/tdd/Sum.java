package com.ht.tdd;

import java.math.BigDecimal;

public class Sum implements Expression {

    final Expression augmend;
    final Expression addmend;

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
        return new Sum(this, addmend);
    }

    @Override
    public Expression times(BigDecimal multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}
