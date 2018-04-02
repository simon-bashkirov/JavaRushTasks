package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a == b) {
            stringBuilder.append(a);
        } else {
            for (int i = a; (a < b ? i <= b : i >= b); i += (a < b ? 1 : -1)) {
                stringBuilder.append(i).append(" ");
            }
        }
        return stringBuilder.toString().substring(0, stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
//        numberA = 13;
//        numberB = 30;
//        System.out.println("numberA = " + numberA);
//        System.out.println("numberB = " + numberB);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}