package ru.netology.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.typeCompatibleWith;

public class CheckingAccountTests {
    CheckingAccount checkingAccount;

    @BeforeEach
    public void beforeEach() {
        checkingAccount = new CheckingAccount(BigDecimal.valueOf(20_000.0));
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void parametrizedTestPayFromCheckingAccount(BigDecimal amount,
                                                       BigDecimal expectedBalance) {
        //arrange
        BigDecimal actualBalance;
        int result;
        int expected = 0;

        checkingAccount.pay(amount);
        actualBalance = checkingAccount.getBalance();

        //act
        result = actualBalance.compareTo(expectedBalance);

        //assert
        assertThat(expected, equalTo(result));
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(10_000.0), BigDecimal.valueOf(10_000.0)),
                Arguments.of(BigDecimal.valueOf(20_000.0), BigDecimal.valueOf(0.0)),
                Arguments.of(BigDecimal.valueOf(40_000.0), BigDecimal.valueOf(20_000.0))
        );
    }

    @Test
    public void payAvailableAmountFromCheckingAccount() {
        //arrange
        BigDecimal amount = BigDecimal.valueOf(100_000.0);
        BigDecimal expectedBalance = BigDecimal.valueOf(20_000);
        BigDecimal actualBalance;
        int result;
        int expected = 0;

        checkingAccount.pay(amount);
        actualBalance = checkingAccount.getBalance();

        //act
        result = actualBalance.compareTo(expectedBalance);

        //assert
        assertThat(expected, equalTo(result));
    }

    @Test
    public void verifyCheckingAccountType() {
        //assert only
        assertThat(checkingAccount.getClass(), typeCompatibleWith(Account.class));
    }
}