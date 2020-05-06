package com.ht.tdd;

import java.math.BigDecimal;
import java.util.HashMap;

class Bank {

    private final HashMap<Pair, BigDecimal> rateMap = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public BigDecimal rate(String from, String to) {
        if (from.equals(to)) return BigDecimal.ONE;
        return rateMap.get(new Pair(from, to));
    }

    public void addRate(String from, String to, BigDecimal rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
