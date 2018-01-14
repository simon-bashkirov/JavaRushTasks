package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Алгоритмы-числа
*/
public class SolutionTest {
    public static void main(String[] args) {
        System.out.println(getNumbers(400));
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> alResult = new ArrayList<>();
        Number number = new Number();

        while (number.itself() < N) {
            number.increment();
            if (number.itself() == number.getSumOfDigitPowerM()) {
                alResult.add(number.itself());
                printNumber(number);
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

    /*public static void numberToDigits(long number) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (number > 0) {
            stack.push((int)(number%10));
            number = number/10;
        }
    }*/

}
