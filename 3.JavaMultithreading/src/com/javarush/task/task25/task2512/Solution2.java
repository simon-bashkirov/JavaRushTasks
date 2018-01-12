package com.javarush.task.task25.task2512;

import java.util.LinkedList;

/*
Живем своим умом
*/
public class Solution2 implements Thread.UncaughtExceptionHandler {

    public Solution2() {
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Throwable e) {
           uncaughtException(Thread.currentThread(), e);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        recursiveCause(e);
    }

    public void recursiveCause(Throwable e) {
        if (e != null) {
            recursiveCause(e.getCause());
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
    }

}
