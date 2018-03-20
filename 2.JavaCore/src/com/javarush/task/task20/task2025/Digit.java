package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

public class Digit {
    private int digit;
    private Long digitPowerM;
    private Number number;
    private static List<List<Long>> matrixOfPowers = new ArrayList<>();

    static {
        for (long i = 0; i <= 9; i++) {
            List<Long> list = new ArrayList<>();
            list.add(i);
            matrixOfPowers.add(list);
        }
    }

    public Digit(Number number) {
        this(0, 0L, number);
    }

    public Digit (int digit, Number number) {
        this(digit, )
    }

    public Digit(int digit, Long digitPowerM, Number number) {
        this.digit = digit;
        this.digitPowerM = digitPowerM;
        this.number = number;
    }

    public static void populateMatrixOfPowers(int power) {
        for (int i = 0; i <= 9; i++) {
            matrixOfPowers.get(i).add((long)Math.pow(i,power));
        }
    }

    public int getDigit() {
        return digit;
    }

    public Long getDigitPowerM() {
        return digitPowerM;
    }

    public void increment() {
        digitPowerM = findMPower(++digit);
    }

    public long findMPower(int digit) {
//        return (long)Math.pow(digit,number.size());
        return matrixOfPowers.get(digit).get(number.size()-1);
    }

    public void setToZero() {
        digit = 0;
        digitPowerM = 0L;
    }

    /*private enum Digits {
        ZERO (0),
        ONE (1),
        TWO (2),
        THREE (3),
        FOUR (4),
        FIVE (5),
        SIX (6),
        SEVEN (7),
        EIGHT (8),
        NINE (9);

        private int value;

        Digits(int value) {
            this.value = value;
        }
    }*/
}
