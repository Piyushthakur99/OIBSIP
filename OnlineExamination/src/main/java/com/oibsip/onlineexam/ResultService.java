package com.oibsip.onlineexam;

import java.util.List;

public class ResultService {

    public void displayResult(List<Question> questions, char[] answers, long elapsedSeconds) {
        int totalQuestions = questions.size();
        int attemptedQuestions = 0;
        int correctAnswers = 0;

        for (int index = 0; index < totalQuestions; index++) {
            char selectedAnswer = answers[index];
            if (selectedAnswer == '-') {
                continue;
            }

            attemptedQuestions++;
            if (Character.toUpperCase(selectedAnswer) == questions.get(index).getCorrectAnswer()) {
                correctAnswers++;
            }
        }

        int wrongAnswers = attemptedQuestions - correctAnswers;
        int percentage = totalQuestions == 0 ? 0 : (correctAnswers * 100) / totalQuestions;
        String status = percentage >= 50 ? "PASS" : "FAIL";

        System.out.println();
        System.out.println("==================== RESULT ======================");
        System.out.println("Total Questions   : " + totalQuestions);
        System.out.println("Attempted         : " + attemptedQuestions);
        System.out.println("Correct Answers   : " + correctAnswers);
        System.out.println("Wrong Answers     : " + wrongAnswers);
        System.out.println("Final Score       : " + correctAnswers + "/" + totalQuestions);
        System.out.println("Percentage        : " + percentage + "%");
        System.out.println("Status            : " + status);
        System.out.println("Time Taken        : " + formatElapsedTime(elapsedSeconds));
        System.out.println("==================================================");
    }

    private String formatElapsedTime(long elapsedSeconds) {
        long minutes = elapsedSeconds / 60;
        long seconds = elapsedSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}