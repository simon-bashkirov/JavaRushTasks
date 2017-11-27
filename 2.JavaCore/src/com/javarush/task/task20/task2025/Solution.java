package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> alresult = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Long> digitsPowerM = new ArrayList<>();
        digits.add(1);
        digitsPowerM.add(1L);

        int powerOfTen = 1;
        int numberOfDigits = 1;


        for (long l = 0; l < N; l++) {
            digits.set(numberOfDigits-1,)
        }

        return result;
    }

    public static void a(long number) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (number > 0) {
            stack.push((int)number%10);
            number = number/10;
        }

    }

    public static void main(String[] args) {
        System.out.println(getNumbers(1000));
    }
}
