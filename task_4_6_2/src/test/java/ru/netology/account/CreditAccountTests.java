package ru.netology.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class CreditAccountTests {
    CreditAccount creditAccount;

    @BeforeEach
    public void beforeEach() {
        creditAccount = new CreditAccount(BigDecimal.valueOf(0.0),
                BigDecimal.valueOf(-400_000.0));
    }

    @Test
    public void testPayFromCreditAccount() {
        //given
        BigDecimal expectedBalance = BigDecimal.valueOf(-20_000);
        BigDecimal actualBalance;
        int result;
        int expected = 0;

        creditAccount.pay(BigDecimal.valueOf(20_000.0));
        actualBalance = creditAccount.getBalance();

        //when
        result = actualBalance.compareTo(expectedBalance);

        //then
        assertThat(expected, equalTo(result));
    }

    @Test
    public void testCreditAccountLowerAndUpperLimits() {
        assertThat(creditAccount.lowerLimit, lessThanOrEqualTo(creditAccount.upperLimit));
    }
}