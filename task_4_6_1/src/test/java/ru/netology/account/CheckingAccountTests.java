package ru.netology.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

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
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(10_000.0), BigDecimal.valueOf(10_000.0)),
                Arguments.of(BigDecimal.valueOf(20_000.0), BigDecimal.valueOf(0.0)),
                Arguments.of(BigDecimal.valueOf(40_000.0), BigDecimal.valueOf(20_000.0))
        );
    }
}