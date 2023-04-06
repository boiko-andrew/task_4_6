package ru.netology.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CreditAccountTests {
    @Test
    public void testPayFromCreditAccount() {
        //given
        CreditAccount creditAccount = new CreditAccount(BigDecimal.valueOf(0.0),
                BigDecimal.valueOf(-400_000.0));
        BigDecimal expectedBalance = BigDecimal.valueOf(-20_000);
        BigDecimal actualBalance;
        int result;
        int expected = 0;

        creditAccount.pay(BigDecimal.valueOf(20_000.0));
        actualBalance = creditAccount.getBalance();

        //when
        result = actualBalance.compareTo(expectedBalance);

        //then
        Assertions.assertEquals(expected, result);
    }
}