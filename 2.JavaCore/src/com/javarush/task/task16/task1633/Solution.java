package com.javarush.task.task16.task1633;

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new TestedThread(commonThread, "Нить 1");
        Thread threadB = new TestedThread(commonThread, "Нить 2");

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
//            start();
        }

        public TestedThread(Thread thread, String name) {
            super(thread, name);
            setUncaughtExceptionHandler(handler);
//            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
                //throw new RuntimeException("Try My exception message");
                //System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException x) {
                //System.out.println(Thread.currentThread().getName() + " throw new RuntimeException");
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
