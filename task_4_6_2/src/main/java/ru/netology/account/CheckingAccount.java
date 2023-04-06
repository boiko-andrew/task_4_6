package ru.netology.account;

import java.math.BigDecimal;

public class CheckingAccount extends Account {
    public CheckingAccount(BigDecimal balance) {
        super("Checking", balance,
                BigDecimal.valueOf(0.0), BigDecimal.valueOf(-1.0),
                true, false);
    }

    @Override
    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.valueOf(0.0)) < 0) {
            System.out.println("Cannot set negative balance for checking account.");
            System.out.println();
        } else {
            super.setBalance(balance);
        }
    }
}