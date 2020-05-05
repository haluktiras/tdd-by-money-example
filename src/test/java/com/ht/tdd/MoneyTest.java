package com.ht.tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    @Test
    public void testMultiplication() {
        Money fiveDollar = Money.dollar(BigDecimal.valueOf(5L));
        assertEquals(Money.dollar(BigDecimal.TEN), fiveDollar.times(BigDecimal.valueOf(2L)));
        assertEquals(Money.dollar(BigDecimal.valueOf(15L)), fiveDollar.times(BigDecimal.valueOf(3L)));

        Money fiveLira = Money.lira(BigDecimal.valueOf(5L));
        assertEquals(Money.lira(BigDecimal.TEN), fiveLira.times(BigDecimal.valueOf(2L)));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(BigDecimal.valueOf(5L)), Money.dollar(BigDecimal.valueOf(5L)));
        assertNotEquals(Money.dollar(BigDecimal.valueOf(5L)), Money.dollar(BigDecimal.TEN));
        assertNotEquals(Money.dollar(BigDecimal.valueOf(5L)), Money.lira(BigDecimal.valueOf(5L)));

        assertEquals(Money.lira(BigDecimal.valueOf(5L)), Money.lira(BigDecimal.valueOf(5L)));
        assertNotEquals(Money.lira(BigDecimal.valueOf(5L)), Money.lira(BigDecimal.TEN));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(BigDecimal.ONE).currency);
        assertEquals("TRY", Money.lira(BigDecimal.ONE).currency);
    }

}