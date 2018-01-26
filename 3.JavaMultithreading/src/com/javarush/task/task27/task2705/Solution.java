package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
*/
public class Solution {
    private final Object lock = new Object();
    private String name;

    public Solution(String name) {
        this.name = name;
    }

    public synchronized void firstMethod() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Solution solution = new Solution("111");
        final Solution solution2 = new Solution("222");
        System.out.println(solution.lock);
        System.out.println(solution2.lock);

        new Thread(new Runnable() {
            public void run() {
                solution.firstMethod();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                solution.secondMethod();
            }
        }).start();
    }
}