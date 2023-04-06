package ru.netology.account;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    public SavingsAccount(BigDecimal balance) {
        super("Savings", balance,
                BigDecimal.valueOf(0.0), BigDecimal.valueOf(-1.0),
                true, false);
    }

    @Override
    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.valueOf(0.0)) < 0) {
            System.out.println("Cannot set negative balance for savings account.");
        } else {
            super.setBalance(balance);
        }
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Your cannot pay from savings account.");
        System.out.println();
    }
}