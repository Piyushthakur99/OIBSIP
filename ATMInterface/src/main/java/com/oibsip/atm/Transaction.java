package com.oibsip.atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    public enum Type {
        DEPOSIT,
        WITHDRAWAL
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private final Type type;
    private final double amount;
    private final double balanceAfterTransaction;
    private final LocalDateTime timestamp;

    private Transaction(Type type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.timestamp = LocalDateTime.now();
    }

    public static Transaction deposit(double amount, double balanceAfterTransaction) {
        return new Transaction(Type.DEPOSIT, amount, balanceAfterTransaction);
    }

    public static Transaction withdrawal(double amount, double balanceAfterTransaction) {
        return new Transaction(Type.WITHDRAWAL, amount, balanceAfterTransaction);
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public String getFormattedTimestamp() {
        return timestamp.format(FORMATTER);
    }

    @Override
    public String toString() {
        return String.format("%s | %-10s | Amount: %.2f | Balance: %.2f", getFormattedTimestamp(), type, amount, balanceAfterTransaction);
    }
}
