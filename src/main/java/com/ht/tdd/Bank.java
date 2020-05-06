package com.ht.tdd;

import java.math.BigDecimal;

public class Bank {

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }
}
