package ru.netology.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SavingsAccountTests {
    @Test
    public void testAddToSavingsAccount() {
        //arrange
        SavingsAccount savingsAccount = new SavingsAccount(BigDecimal.valueOf(40_000.0));
        BigDecimal expectedBalance = BigDecimal.valueOf(120_000);
        BigDecimal actualBalance;
        int result;
        int expected = 0;

        savingsAccount.addMoney(BigDecimal.valueOf(80_000.0));
        actualBalance = savingsAccount.getBalance();

        //act
        result = actualBalance.compareTo(expectedBalance);

        //assert
        Assertions.assertEquals(expected, result);
    }
}