package com.oibsip.onlineexam;

import java.util.Scanner;

public class LoginService {

    public boolean login(User user, Scanner scanner) {
        System.out.println();
        System.out.println("Please log in to continue.");

        while (true) {
            System.out.print("Enter User ID: ");
            String enteredUserId = scanner.nextLine().trim();
            System.out.print("Enter Password: ");
            String enteredPassword = scanner.nextLine().trim();

            if (user.getUserId().equals(enteredUserId) && user.getPassword().equals(enteredPassword)) {
                System.out.println("Login successful. Welcome, " + user.getFullName() + "!");
                return true;
            }

            System.out.println("Invalid User ID or Password.");
            System.out.print("Do you want to try again? (Y/N): ");
            String retry = scanner.nextLine().trim();
            if (!retry.equalsIgnoreCase("Y")) {
                return false;
            }
        }
    }

    public void updatePassword(User user, Scanner scanner) {
        System.out.println();
        System.out.println("---------------- UPDATE PASSWORD ----------------");

        System.out.print("Enter Current Password: ");
        String currentPassword = scanner.nextLine().trim();
        if (!user.getPassword().equals(currentPassword)) {
            System.out.println("Current password is incorrect.");
            return;
        }

        System.out.print("Enter New Password: ");
        String newPassword = scanner.nextLine().trim();
        if (newPassword.isEmpty()) {
            System.out.println("New password cannot be empty.");
            return;
        }

        System.out.print("Confirm New Password: ");
        String confirmPassword = scanner.nextLine().trim();

        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Password confirmation does not match.");
            return;
        }

        user.setPassword(newPassword);
        System.out.println("Password updated successfully.");
    }
}