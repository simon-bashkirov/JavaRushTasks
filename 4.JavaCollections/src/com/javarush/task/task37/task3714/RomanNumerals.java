package com.javarush.task.task37.task3714;

import java.util.Arrays;

public enum RomanNumerals {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int intValue;
    private boolean repeatable;

    RomanNumerals(int intValue) {
        this.intValue = intValue;
        repeatable = getFirstDigit(this.intValue) == 1;
    }

    public int getIntValue() {
        return intValue;
    }

    public static int getIntValueByString(char numeral) {
        try {
            return valueOf(String.valueOf(Character.toUpperCase(numeral))).intValue;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + ", should be one of " + Arrays.toString(values()));
        }
    }

    private int getFirstDigit(int intValue) {
        while (intValue >= 10) {
            intValue /= 10;
        }
        return intValue;
    }

    @Override
    public String toString() {
        return "RomanNumerals{" +
                "intValue=" + intValue +
                ", repeatable=" + repeatable +
                '}';
    }
}
