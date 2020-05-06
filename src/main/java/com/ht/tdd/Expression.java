package com.ht.tdd;

public interface Expression {
    Money reduce(Bank bank, String to);
}
