package com.ht.tdd;

import java.math.BigDecimal;

public class Sum implements Expression{

    Money augmend;
    Money addmend;

    public Sum(Money augmend, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    public Money reduce(String to) {
        BigDecimal amount = augmend.amount.add(addmend.amount);
        return new Money(amount, to);
    }
}
