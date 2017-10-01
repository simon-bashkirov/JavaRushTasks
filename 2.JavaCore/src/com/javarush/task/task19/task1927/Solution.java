package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultSystemOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newSystemOut = new PrintStream(outputStream);
        System.setOut(newSystemOut);

        testString.printSomething();

        System.setOut(defaultSystemOut);

        String[] rows = outputStream.toString().split("\n");

        int i = 0;
        for (String s : rows) {
            i++;
//            System.out.print("i-1=" + (i-1) + ", i-1 % 2=" + (i-1 % 2) + " >> ");
            if ((i-1) > 0 && (i-1) % 2 == 0) System.out.println("JavaRush - курсы Java онлайн");
            System.out.println(s);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
