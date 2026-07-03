package com.oibsip.numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final String BORDER = "============================================================";

    private final Scanner scanner;
    private final Random random;

    public NumberGuessingGame() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void start() {
        showWelcomeScreen();

        boolean playAgain;
        do {
            playRound();
            playAgain = restartGame();
        } while (playAgain);

        showEndingScreen();
        scanner.close();
    }

    private void playRound() {
        int targetNumber = generateRandomNumber();
        int attempts = 0;
        boolean guessedCorrectly = false;

        printSection("New Round Started");
        System.out.println("I have selected a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("Try to guess it in as few attempts as possible.");
        System.out.println();

        while (!guessedCorrectly) {
            int guess = readGuess();
            attempts++;

            GuessFeedback feedback = checkGuess(guess, targetNumber);
            if (feedback == GuessFeedback.CORRECT) {
                System.out.println();
                System.out.println("Correct! You guessed the number " + targetNumber + ".");
                displayScore(attempts);
                guessedCorrectly = true;
            } else if (feedback == GuessFeedback.TOO_LOW) {
                System.out.println("Too low. Try a higher number.");
            } else {
                System.out.println("Too high. Try a lower number.");
            }
        }
    }

    private int generateRandomNumber() {
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    private GuessFeedback checkGuess(int guess, int targetNumber) {
        if (guess < targetNumber) {
            return GuessFeedback.TOO_LOW;
        }

        if (guess > targetNumber) {
            return GuessFeedback.TOO_HIGH;
        }

        return GuessFeedback.CORRECT;
    }

    private void displayScore(int attempts) {
        int score = calculateScore(attempts);

        System.out.println();
        printSection("Round Summary");
        System.out.printf("Attempts used : %d%n", attempts);
        System.out.printf("Score         : %d%n", score);

        if (attempts == 1) {
            System.out.println("Performance   : Perfect guess!");
        } else if (attempts <= 3) {
            System.out.println("Performance   : Excellent");
        } else if (attempts <= 6) {
            System.out.println("Performance   : Good");
        } else {
            System.out.println("Performance   : Keep practicing");
        }

        System.out.println(BORDER);
    }

    private int calculateScore(int attempts) {
        int score = 110 - (attempts * 10);
        return Math.max(score, 10);
    }

    private boolean restartGame() {
        while (true) {
            System.out.println();
            System.out.print("Do you want to play again? (Y/N): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Y")) {
                return true;
            }

            if (input.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Invalid choice. Please enter Y or N.");
        }
    }

    private int readGuess() {
        while (true) {
            System.out.printf("Enter your guess (%d-%d): ", MIN_NUMBER, MAX_NUMBER);
            String input = scanner.nextLine().trim();

            try {
                int guess = Integer.parseInt(input);

                if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                    System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                    continue;
                }

                return guess;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a valid whole number.");
            }
        }
    }

    private void showWelcomeScreen() {
        printSection("Welcome to the Number Guessing Game");
        System.out.println("Rules:");
        System.out.println("1. Guess the number selected by the computer.");
        System.out.println("2. The number will always be between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("3. You will receive hints after every guess.");
        System.out.println("4. Your score depends on how quickly you guess the answer.");
        System.out.println();
        System.out.println("Good luck and enjoy the game!");
        System.out.println(BORDER);
    }

    private void showEndingScreen() {
        System.out.println();
        printSection("Thank You for Playing");
        System.out.println("Hope you enjoyed the game.");
        System.out.println("See you next time!");
        System.out.println(BORDER);
    }

    private void printSection(String title) {
        System.out.println();
        System.out.println(BORDER);
        System.out.printf("%s%n", title);
        System.out.println(BORDER);
    }
}
