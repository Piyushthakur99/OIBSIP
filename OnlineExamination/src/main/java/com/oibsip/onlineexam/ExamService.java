package com.oibsip.onlineexam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExamService {

    private final TimerService timerService;
    private final ResultService resultService;

    public ExamService(TimerService timerService, ResultService resultService) {
        this.timerService = timerService;
        this.resultService = resultService;
    }

    public void startExamination(User user, List<Question> questions, Scanner scanner) {
        System.out.println();
        System.out.println("---------------- START EXAMINATION ----------------");
        System.out.println("The exam has 10 questions and a total duration of 2 minutes.");
        System.out.println("Answer one question at a time.");
        System.out.println("----------------------------------------------------");

        timerService.startExamTimer();
        char[] answers = new char[questions.size()];
        Arrays.fill(answers, '-');

        boolean timeUp = false;

        for (int index = 0; index < questions.size(); index++) {
            if (timerService.isTimeUp()) {
                timeUp = true;
                break;
            }

            System.out.println("Remaining Time: " + timerService.getRemainingTimeLabel());
            questions.get(index).displayQuestion(index + 1);

            String userAnswer = readValidAnswer(scanner);
            if (timerService.isTimeUp()) {
                timeUp = true;
                break;
            }

            answers[index] = Character.toUpperCase(userAnswer.charAt(0));
        }

        if (timeUp) {
            System.out.println();
            System.out.println("Time Up! Exam Submitted Successfully.");
        } else {
            System.out.println();
            System.out.println("Exam Submitted Successfully.");
        }

        user.incrementExamsAttempted();
        resultService.displayResult(questions, answers, timerService.getElapsedSeconds());
    }

    private String readValidAnswer(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.length() == 1) {
                char answer = Character.toUpperCase(input.charAt(0));
                if (answer == 'A' || answer == 'B' || answer == 'C' || answer == 'D') {
                    return String.valueOf(answer);
                }
            }

            System.out.print("Please enter only A, B, C, or D: ");
        }
    }
}