package com.ht.tdd;

import java.math.BigDecimal;

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(BigDecimal multiplier);
}
