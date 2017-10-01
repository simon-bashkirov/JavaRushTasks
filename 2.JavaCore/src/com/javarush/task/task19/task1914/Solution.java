package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String result = solveEquation(outputStream.toString().trim());
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static String solveEquation(String s) {
        String[] terms = s.split(" ");
        String operator = terms[1];
        String result = s;
        if (operator.equals("+")) {
            result += " " + (Integer.parseInt(terms[0]) + Integer.parseInt(terms[2]));
        } else if (operator.equals("-")) {
            result += " " + (Integer.parseInt(terms[0]) - Integer.parseInt(terms[2]));
        } else if (operator.equals("*")) {
            result += " " + (Integer.parseInt(terms[0]) * Integer.parseInt(terms[2]));
        }
        return result;
    }
}

