package com.oibsip.atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private final String userId;
    private final String pin;
    private double balance;
    private final List<Transaction> transactionHistory;

    public Account(String userId, String pin, double openingBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = openingBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }

        balance += amount;
        transactionHistory.add(Transaction.deposit(amount, balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance. Withdrawal cancelled.");
        }

        balance -= amount;
        transactionHistory.add(Transaction.withdrawal(amount, balance));
    }

    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }
}
