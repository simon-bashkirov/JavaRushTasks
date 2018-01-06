package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State state = null;
        while (thread.getState() != State.TERMINATED) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//                System.out.println("debug: " + thread.getState());
            if (thread.getState() != state) {
                state = thread.getState();
                System.out.println(state);
            }

        }
    }
}
