package com.oibsip.onlineexam;

public class TimerService {

    private final int totalDurationSeconds;
    private long startTimeMillis;

    public TimerService(int totalDurationSeconds) {
        this.totalDurationSeconds = totalDurationSeconds;
    }

    public void startExamTimer() {
        startTimeMillis = System.currentTimeMillis();
    }

    public boolean isTimeUp() {
        return getRemainingSeconds() <= 0;
    }

    public long getRemainingSeconds() {
        long elapsedSeconds = (System.currentTimeMillis() - startTimeMillis) / 1000;
        return totalDurationSeconds - elapsedSeconds;
    }

    public long getElapsedSeconds() {
        return (System.currentTimeMillis() - startTimeMillis) / 1000;
    }

    public String getRemainingTimeLabel() {
        long remainingSeconds = Math.max(0, getRemainingSeconds());
        long minutes = remainingSeconds / 60;
        long seconds = remainingSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}