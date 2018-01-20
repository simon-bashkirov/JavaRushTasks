package com.javarush.task.task25.task2510;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/*
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) System.out.println("Нельзя дальше работать");
                else if (e instanceof Exception) System.out.println("Надо обработать");
                else if (e != null) {
                    System.out.println("ХЗ");
                }
            }
        });

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();

    }

    @Override
    public void run() {
        throw new ArrayIndexOutOfBoundsException();
    }
}
