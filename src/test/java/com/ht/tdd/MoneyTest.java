package com.ht.tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    public static final BigDecimal CONST_TWO = valueOf(2L);
    public static final BigDecimal CONST_THREE = valueOf(3L);
    public static final BigDecimal CONST_FIVE = valueOf(5L);
    public static final BigDecimal CONST_SEVEN = valueOf(7L);

    public static final String CONST_CURRENCY_NAME_TRY = "TRY";
    public static final String CONST_CURRENCY_NAME_USD = "USD";

    @Test
    public void testMultiplication() {
        Money fiveDollar = Money.dollar(CONST_FIVE);
        assertEquals(Money.dollar(TEN), fiveDollar.times(CONST_TWO));
        assertEquals(Money.dollar(valueOf(15L)), fiveDollar.times(CONST_THREE));

        Money fiveLira = Money.lira(CONST_FIVE);
        assertEquals(Money.lira(TEN), fiveLira.times(CONST_TWO));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(CONST_FIVE), Money.dollar(CONST_FIVE));
        assertNotEquals(Money.dollar(CONST_FIVE), Money.dollar(TEN));
        assertNotEquals(Money.dollar(CONST_FIVE), Money.lira(CONST_FIVE));

        assertEquals(Money.lira(CONST_FIVE), Money.lira(CONST_FIVE));
        assertNotEquals(Money.lira(CONST_FIVE), Money.lira(TEN));
    }

    @Test
    public void testCurrency() {
        assertEquals(CONST_CURRENCY_NAME_USD, Money.dollar(ONE).currency);
        assertEquals(CONST_CURRENCY_NAME_TRY, Money.lira(ONE).currency);
    }

    @Test
    public void testSimpleAddition() {
        Money fiveDollar = Money.dollar(CONST_FIVE);
        Expression sum = fiveDollar.plus(fiveDollar);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, CONST_CURRENCY_NAME_USD);
        assertEquals(Money.dollar(TEN), reduced);
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
        Money result = bank.reduce(sum, CONST_CURRENCY_NAME_USD);
        assertEquals(Money.dollar(CONST_FIVE), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(ONE), CONST_CURRENCY_NAME_USD);
        assertEquals(Money.dollar(ONE), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate(CONST_CURRENCY_NAME_TRY, CONST_CURRENCY_NAME_USD, CONST_SEVEN);
        Money result = bank.reduce(Money.lira(CONST_SEVEN), CONST_CURRENCY_NAME_USD);
        assertEquals(Money.dollar(ONE), result);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(ONE, new Bank().rate(CONST_CURRENCY_NAME_USD, CONST_CURRENCY_NAME_USD));
        assertEquals(ONE, new Bank().rate(CONST_CURRENCY_NAME_TRY, CONST_CURRENCY_NAME_TRY));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveDollars = Money.dollar(CONST_FIVE);
        Expression thirtyFiveLiras = Money.lira(valueOf(35L));
        Bank bank = new Bank();
        bank.addRate(CONST_CURRENCY_NAME_TRY, CONST_CURRENCY_NAME_USD, CONST_SEVEN);
        Money result = bank.reduce(fiveDollars.plus(thirtyFiveLiras), CONST_CURRENCY_NAME_USD);
        assertEquals(Money.dollar(TEN), result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveDollars = Money.dollar(CONST_FIVE);
        Expression tenLiras = Money.lira(TEN);
        Bank bank = new Bank();
        bank.addRate(CONST_CURRENCY_NAME_TRY, CONST_CURRENCY_NAME_USD, CONST_TWO);
        Expression sum = new Sum(fiveDollars, tenLiras).plus(fiveDollars);
        Money result = bank.reduce(sum, CONST_CURRENCY_NAME_USD);
        assertEquals(Money.dollar(valueOf(15L)), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveDollars = Money.dollar(CONST_FIVE);
        Expression tenLiras = Money.lira(TEN);
        Bank bank = new Bank();
        bank.addRate(CONST_CURRENCY_NAME_TRY, CONST_CURRENCY_NAME_USD, CONST_TWO);
        Expression sum = new Sum(fiveDollars, tenLiras).times(CONST_TWO);
        Money result = bank.reduce(sum, CONST_CURRENCY_NAME_USD);
        assertEquals(Money.dollar(valueOf(20L)), result);
    }

}