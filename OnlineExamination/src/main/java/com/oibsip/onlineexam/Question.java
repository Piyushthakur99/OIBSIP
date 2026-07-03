package com.oibsip.onlineexam;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private final String text;
    private final String[] options;
    private final char correctAnswer;

    public Question(String text, String optionA, String optionB, String optionC, String optionD, char correctAnswer) {
        this.text = text;
        this.options = new String[] { optionA, optionB, optionC, optionD };
        this.correctAnswer = Character.toUpperCase(correctAnswer);
    }

    public String getText() {
        return text;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public void displayQuestion(int questionNumber) {
        System.out.println();
        System.out.println("Question " + questionNumber);
        System.out.println(text);
        System.out.println();
        System.out.println("A. " + options[0]);
        System.out.println("B. " + options[1]);
        System.out.println("C. " + options[2]);
        System.out.println("D. " + options[3]);
        System.out.print("Enter answer (A/B/C/D): ");
    }

    public static List<Question> createDefaultQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is JVM?", "Java Variable Manager", "Java Virtual Machine", "Java Version Manager", "Java Visual Model", 'B'));
        questions.add(new Question("Which keyword is used to create an object in Java?", "make", "new", "create", "object", 'B'));
        questions.add(new Question("Which concept binds data and methods together?", "Inheritance", "Polymorphism", "Encapsulation", "Abstraction", 'C'));
        questions.add(new Question("How many primitive data types are there in Java?", "6", "7", "8", "9", 'C'));
        questions.add(new Question("Which loop is guaranteed to execute at least once?", "for", "while", "do-while", "enhanced for", 'C'));
        questions.add(new Question("Which class is used to handle input from the console?", "Scanner", "InputReader", "ConsoleReader", "BufferInput", 'A'));
        questions.add(new Question("What does the length() method return for a String?", "Number of characters", "Number of words", "Number of lines", "Memory size", 'A'));
        questions.add(new Question("Which operator is used for logical AND in Java?", "&&", "||", "!", "^", 'A'));
        questions.add(new Question("Which collection stores unique elements only?", "ArrayList", "LinkedList", "HashSet", "Vector", 'C'));
        questions.add(new Question("What is the default value of a boolean variable?", "0", "false", "true", "null", 'B'));
        return questions;
    }
}