package com.oibsip.atm;

import java.util.List;
import java.util.Scanner;

public class ATM {

    private static final String SEPARATOR = "==================================================";
    private static final String SUB_SEPARATOR = "--------------------------------------------------";

    private final Account account;
    private final UserAuthentication authentication;
    private final Scanner scanner;

    public ATM(Account account, UserAuthentication authentication) {
        this.account = account;
        this.authentication = authentication;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        printWelcomeScreen();

        if (!login()) {
            printExitScreen();
            return;
        }

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    checkBalance();
                    pauseForUser();
                    break;
                case 2:
                    depositMoney();
                    pauseForUser();
                    break;
                case 3:
                    withdrawMoney();
                    pauseForUser();
                    break;
                case 4:
                    showTransactionHistory();
                    pauseForUser();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid menu option.");
            }
        }

        printExitScreen();
    }

    private void printWelcomeScreen() {
        System.out.println(SEPARATOR);
        System.out.println("            WELCOME TO OIBSIP ATM INTERFACE           ");
        System.out.println(SEPARATOR);
        System.out.println("Demo User ID : 12345678");
        System.out.println("Demo PIN     : 4321");
        System.out.println(SEPARATOR);
    }

    private boolean login() {
        System.out.println("Please log in to continue.");

        for (int attempt = 1; attempt <= 3; attempt++) {
            try {
                String userId = readInput("Enter User ID: ");

                String pin = readInput("Enter PIN: ");

                if (authentication.validateCredentials(userId, pin, account)) {
                    System.out.println("Login successful. Welcome!");
                    System.out.println(SEPARATOR);
                    return true;
                }

                System.out.println("Invalid User ID or PIN. Attempts remaining: " + (3 - attempt));
            } catch (Exception exception) {
                System.out.println("Login failed due to an unexpected error. Please try again.");
            }
        }

        System.out.println("Too many invalid attempts. Access denied.");
        return false;
    }

    private void showMenu() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("                       ATM MENU                       ");
        System.out.println(SEPARATOR);
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.println(SUB_SEPARATOR);
    }

    private int readMenuChoice() {
        while (true) {
            try {
                String input = readInput("Select an option: ");
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }
    }

    private void checkBalance() {
        System.out.println(SUB_SEPARATOR);
        System.out.printf("Current Balance: %.2f%n", account.getBalance());
        System.out.println(SUB_SEPARATOR);
    }

    private void depositMoney() {
        double amount = readAmount("Enter deposit amount: ");

        try {
            account.deposit(amount);
            System.out.printf("Deposit successful. New balance: %.2f%n", account.getBalance());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void withdrawMoney() {
        double amount = readAmount("Enter withdrawal amount: ");

        try {
            account.withdraw(amount);
            System.out.printf("Withdrawal successful. New balance: %.2f%n", account.getBalance());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private double readAmount(String prompt) {
        while (true) {
            try {
                String input = readInput(prompt);
                double amount = Double.parseDouble(input);

                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero. Please try again.");
                    continue;
                }

                return amount;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }
    }

    private String readInput(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        return scanner.nextLine().trim();
    }

    private void pauseForUser() {
        System.out.print("Press Enter to continue...");
        System.out.flush();
        scanner.nextLine();
    }

    private void showTransactionHistory() {
        List<Transaction> transactions = account.getTransactionHistory();

        System.out.println(SEPARATOR);
        System.out.println("                  TRANSACTION HISTORY                 ");
        System.out.println(SEPARATOR);

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }

        System.out.println(SEPARATOR);
    }

    private void printExitScreen() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("           THANK YOU FOR USING OIBSIP ATM            ");
        System.out.println("                HAVE A GREAT DAY!                    ");
        System.out.println(SEPARATOR);
    }
}
