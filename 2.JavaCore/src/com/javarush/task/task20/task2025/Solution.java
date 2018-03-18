package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/*
Алгоритмы-числа
*/
public class Solution {
    public static void main(String[] args) {
        double beforeTs = System.currentTimeMillis();
//        System.out.println(getNumbers(10000));
        System.out.println(Arrays.toString(getNumbers(200_000)));
        double afterTs = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        double memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Time elapsed: " + (afterTs-beforeTs)/1000);
        System.out.println("Used memory is megabytes: " + memory/1024/1024);
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> alResult = new ArrayList<>();
        Number number = new Number();

        while (number.itself() < N) {
            number.increment();
            if (number.itself() == number.getSumOfDigitPowerM()) {
                alResult.add(number.itself());
//                printNumber(number);
            }
        }

        result = new long[alResult.size()];
        for (int i = 0; i < alResult.size(); i++) {
            result[i] = alResult.get(i);
        }

        return result;
    }

    public static void printNumber(Number number) {
        StringBuilder output = new StringBuilder(number.itself() + " = ");
        int i = 0;
        for (Digit digit : number.getDigits()) {
            if (i > 0) output.append(" + ");
            int j = 0;
            while (j < number.size()) {
                output.append((j == 0 ? "" : "*") + digit.getDigit());
                j++;
            }
            i++;
        }
        System.out.println(output.toString());
    }
}
