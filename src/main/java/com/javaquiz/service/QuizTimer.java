package com.javaquiz.service;

/**
 * Background countdown demonstrating Java multithreading.
 * The remaining time is protected by synchronization so readers get a consistent value.
 */
public class QuizTimer extends Thread {
    private final int totalSeconds;
    private int remaining;
    private volatile boolean running = true;

    public QuizTimer(int totalSeconds) {
        if (totalSeconds < 0) throw new IllegalArgumentException("Time cannot be negative");
        this.totalSeconds = totalSeconds;
        this.remaining = totalSeconds;
        setName("quiz-timer");
        setDaemon(true);
    }

    public synchronized int getRemaining() { return remaining; }
    public synchronized boolean isFinished() { return remaining == 0; }
    public synchronized int getTotalSeconds() { return totalSeconds; }

    public void stopTimer() {
        running = false;
        interrupt();
    }

    @Override
    public void run() {
        try {
            while (running) {
                synchronized (this) {
                    if (remaining <= 0) break;
                }
                Thread.sleep(1000);
                synchronized (this) {
                    if (remaining > 0) remaining--;
                }
            }
        } catch (InterruptedException ignored) {
            // Expected when stopTimer() is called.
            Thread.currentThread().interrupt();
        }
    }
}
