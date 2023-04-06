package ru.netology.account;

import java.math.BigDecimal;

public abstract class Account {

    protected String accountType;
    protected BigDecimal balance;
    protected BigDecimal lowerLimit;
    protected BigDecimal upperLimit;
    protected boolean hasLowerLimit;
    protected boolean hasUpperLimit;

    protected Account(String accountType, BigDecimal balance,
                      BigDecimal lowerLimit, BigDecimal upperLimit,
                      boolean hasLowerLimit, boolean hasUpperLimit) {
        this.accountType = accountType;
        this.balance = balance;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.hasLowerLimit = hasLowerLimit;
        this.hasUpperLimit = hasUpperLimit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private BigDecimal getAvailableToAdd() {
        return hasUpperLimit ? upperLimit.subtract(balance) : BigDecimal.valueOf(-1.0);
    }

    private BigDecimal getAvailableToSubtract() {
        return hasLowerLimit ? balance.subtract(lowerLimit) : BigDecimal.valueOf(-1.0);
    }

    private boolean add(BigDecimal amount) {
        BigDecimal availableToAdd = getAvailableToAdd();
        if (availableToAdd.compareTo(BigDecimal.valueOf(0.0)) > 0
                && amount.compareTo(availableToAdd) > 0) {
            System.out.println("Cannot add such amount to "
                    + accountType.toLowerCase() + " account.");
            System.out.println("Available amount to add is " + availableToAdd + " rub.");
            return false;
        } else {
            BigDecimal oldBalance = this.getBalance();
            BigDecimal newBalance = oldBalance.add(amount);
            this.setBalance(newBalance);
            System.out.println(accountType + " account old balance was " + oldBalance + " rub.");
            System.out.println("You added " + amount + " rub.");
            System.out.println(accountType + " account new balance is " + newBalance + " rub.");
            return true;
        }
    }

    private boolean subtract(BigDecimal amount) {
        BigDecimal availableToSubtract = getAvailableToSubtract();
        if (availableToSubtract.compareTo(BigDecimal.valueOf(0.0)) > 0
                && amount.compareTo(availableToSubtract) > 0) {
            System.out.println("Cannot subtract such amount from "
                    + accountType.toLowerCase() + " account.");
            System.out.println("Available amount to subtract is " + availableToSubtract + " rub.");
            return false;
        } else {
            BigDecimal oldBalance = this.getBalance();
            BigDecimal newBalance = oldBalance.subtract(amount);
            this.setBalance(newBalance);
            System.out.println(accountType + " account old balance was " + oldBalance + " rub.");
            System.out.println("You subtracted " + amount + " rub.");
            System.out.println(accountType + " account new balance is " + newBalance + " rub.");
            return true;
        }
    }

    public void pay(BigDecimal amount) {
        boolean result = subtract(amount);
        if (result) {
            System.out.println("Payment transaction is successful.");
        } else {
            System.out.println("Payment transaction is aborted.");
        }
        System.out.println();
    }

    public void transfer(Account account, BigDecimal amount) {
        boolean subtractResult = this.subtract(amount);
        //System.out.println();
        if (subtractResult) {
            System.out.println();
            boolean addResult = account.add(amount);
            if (addResult) {
                System.out.println("Transferring transaction is successful.");
            } else {
                System.out.println("Transferring transaction is aborted.");
                System.out.println();
                System.out.println("Money is returned to source account.");
                System.out.println();
                this.add(amount);
            }
        } else {
            System.out.println("Transferring transaction is aborted.");
        }
        System.out.println();
    }

    public void addMoney(BigDecimal amount) {
        boolean result = add(amount);
        if (result) {
            System.out.println("Adding money transaction is successful.");
        } else {
            System.out.println("Adding money transaction is aborted.");
        }
        System.out.println();
    }
}