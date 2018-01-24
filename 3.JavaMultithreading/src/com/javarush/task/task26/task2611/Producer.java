package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int counter = 1;
        while (!currentThread.isInterrupted()) {
            map.put(String.valueOf(counter), "Some text for " + counter);
            counter++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(currentThread.getName() + " thread was terminated");
                currentThread.interrupt();
            }
        }
    }
}
