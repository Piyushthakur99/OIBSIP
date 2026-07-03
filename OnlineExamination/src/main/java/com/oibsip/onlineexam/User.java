package com.oibsip.onlineexam;

public class User {

    private final String fullName;
    private final String userId;
    private String password;
    private final String course;
    private int examsAttempted;

    public User(String fullName, String userId, String password, String course) {
        this.fullName = fullName;
        this.userId = userId;
        this.password = password;
        this.course = course;
        this.examsAttempted = 0;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public int getExamsAttempted() {
        return examsAttempted;
    }

    public void incrementExamsAttempted() {
        examsAttempted++;
    }
}