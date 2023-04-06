package ru.netology.account;

import java.math.BigDecimal;

public class CreditAccount extends Account {

    public CreditAccount(BigDecimal balance, BigDecimal creditLimit) {
        super("Credit", balance,
                creditLimit, BigDecimal.valueOf(0.0),
                true, true);
    }

    @Override
    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.valueOf(0.0)) > 0) {
            System.out.println("Cannot set positive balance for credit account.");
            System.out.println();
            return;
        }
        if (balance.compareTo(lowerLimit) < 0) {
            System.out.println("Cannot set balance less than credit limit "
                    + "for credit account.");
            System.out.println();
            return;
        }
        super.setBalance(balance);
    }
}