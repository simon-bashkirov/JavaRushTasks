package com.javarush.task.task25.task2512;

import java.util.LinkedList;

/*
Живем своим умом
*/
public class Solution1 implements Thread.UncaughtExceptionHandler {

    public Solution1() {
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Throwable e) {
           uncaughtException(Thread.currentThread(), e);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        LinkedList<Throwable> throwables = new LinkedList<>();
        do {
            throwables.add(0, e);
            e = e.getCause();
        } while (e != null);
        for (Throwable throwable : throwables) {
            System.out.println(throwable);
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        /*Thread t = new Thread(solution);
        t.setUncaughtExceptionHandler(solution);
        t.start();*/
    }

}
