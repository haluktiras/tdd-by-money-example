package com.ht.tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    public static final BigDecimal CONST_TWO = BigDecimal.valueOf(2L);
    public static final BigDecimal CONST_THREE = BigDecimal.valueOf(3L);
    public static final BigDecimal CONST_FIVE = BigDecimal.valueOf(5L);

    @Test
    public void testMultiplication() {
        Money fiveDollar = Money.dollar(CONST_FIVE);
        assertEquals(Money.dollar(BigDecimal.TEN), fiveDollar.times(CONST_TWO));
        assertEquals(Money.dollar(BigDecimal.valueOf(15L)), fiveDollar.times(CONST_THREE));

        Money fiveLira = Money.lira(CONST_FIVE);
        assertEquals(Money.lira(BigDecimal.TEN), fiveLira.times(CONST_TWO));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(CONST_FIVE), Money.dollar(CONST_FIVE));
        assertNotEquals(Money.dollar(CONST_FIVE), Money.dollar(BigDecimal.TEN));
        assertNotEquals(Money.dollar(CONST_FIVE), Money.lira(CONST_FIVE));

        assertEquals(Money.lira(CONST_FIVE), Money.lira(CONST_FIVE));
        assertNotEquals(Money.lira(CONST_FIVE), Money.lira(BigDecimal.TEN));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(BigDecimal.ONE).currency);
        assertEquals("TRY", Money.lira(BigDecimal.ONE).currency);
    }

    @Test
    public void testSimpleAddition() {
        Money fiveDollar = Money.dollar(CONST_FIVE);
        Expression sum = fiveDollar.plus(fiveDollar);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(BigDecimal.TEN), reduced);
    }

    @Test
    public void testPlusReturnSum() {
        Money fiveDollar = Money.dollar(CONST_FIVE);
        Expression result = fiveDollar.plus(fiveDollar);
        Sum sum = (Sum) result;
        assertEquals(fiveDollar, sum.augmend);
        assertEquals(fiveDollar, sum.addmend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(CONST_TWO), Money.dollar(CONST_THREE));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(CONST_FIVE), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(BigDecimal.ONE), "USD");
        assertEquals(Money.dollar(BigDecimal.ONE), result);
    }

}