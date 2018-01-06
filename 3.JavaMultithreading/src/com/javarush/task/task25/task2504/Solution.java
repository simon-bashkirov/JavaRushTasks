package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                case BLOCKED:
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread t = new Thread(a);
        for (int i = 0; i < 50; i++) {
            processThreads(t);
            Thread.sleep(250);
        }
    }

    public static class A implements Runnable {
        public int counter;

        public A() {
            counter = 0;
        }

        @Override
        public void run() {
            while (counter < 30) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                    e.printStackTrace();
                }
                counter++;
            }
        }
    }
}
