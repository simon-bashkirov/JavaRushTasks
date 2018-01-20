package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    @Override
    public void run() {
//        int counter = 0; //!thread.isInterrupted()
        while (true) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            counter++;
        }
    }

    @Override
    public void start(String threadName) {
//        thread = new Thread(new Solution.A(), threadName);
        thread = new Thread(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
