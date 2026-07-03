package com.oibsip.onlineexam;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        User user = new User("Aarav Sharma", "oibsip01", "java123", "Core Java Programming");
        LoginService loginService = new LoginService();
        ResultService resultService = new ResultService();
        TimerService timerService = new TimerService(120);
        ExamService examService = new ExamService(timerService, resultService);
        List<Question> questions = Question.createDefaultQuestions();

        try (Scanner scanner = new Scanner(System.in)) {
            printWelcome();

            boolean loggedIn = loginService.login(user, scanner);
            if (!loggedIn) {
                System.out.println("Application closed.");
                return;
            }

            boolean running = true;
            while (running) {
                printMenu(user);
                int choice = readMenuChoice(scanner);

                switch (choice) {
                    case 1 -> examService.startExamination(user, questions, scanner);
                    case 2 -> loginService.updatePassword(user, scanner);
                    case 3 -> displayProfile(user);
                    case 4 -> {
                        printLogoutMessage();
                        running = false;
                    }
                    default -> System.out.println("Please select a valid option.");
                }
            }
        }
    }

    private static void printWelcome() {
        System.out.println("==================================================");
        System.out.println("           ONLINE EXAMINATION SYSTEM");
        System.out.println("==================================================");
        System.out.println("Demo User ID : oibsip01");
        System.out.println("Demo Password: java123");
        System.out.println("==================================================");
    }

    private static void printMenu(User user) {
        System.out.println();
        System.out.println("-------------------- MAIN MENU --------------------");
        System.out.println("Welcome, " + user.getFullName());
        System.out.println("1. Start Examination");
        System.out.println("2. Update Password");
        System.out.println("3. View Profile");
        System.out.println("4. Logout");
        System.out.println("--------------------------------------------------");
        System.out.print("Select an option: ");
    }

    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.print("Enter a valid number (1-4): ");
            }
        }
    }

    private static void displayProfile(User user) {
        System.out.println();
        System.out.println("------------------- PROFILE -------------------");
        System.out.println("User Name        : " + user.getFullName());
        System.out.println("User ID          : " + user.getUserId());
        System.out.println("Course           : " + user.getCourse());
        System.out.println("Exams Attempted  : " + user.getExamsAttempted());
        System.out.println("------------------------------------------------");
    }

    private static void printLogoutMessage() {
        System.out.println();
        System.out.println("Thank You for using the Online Examination System.");
        System.out.println("Goodbye!");
    }
}