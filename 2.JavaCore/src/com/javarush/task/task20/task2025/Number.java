package com.javarush.task.task20.task2025;

import java.util.ArrayList;

public class Number {
    private ArrayList<Digit> digits = new ArrayList<>();
//    public Digit currentDigit;
    private int currentDigitIndex;
    private long numberItself;

    public Number() {
        digits.add(new Digit(0,0L));
        currentDigitIndex = 0;
        numberItself = 0;
    }

    public void increment() {
        currentDigitIndex = digits.size()-1;
        numberItself++;
        incrementDigits();
    }

    private void incrementDigits() {
        if (getCurrentDigit().getDigit() < 9) {
            getCurrentDigit().increment(digits.size());
        } else {
            getCurrentDigit().setToZero();
            if (currentDigitIndex > 0) {
                currentDigitIndex--;
                incrementDigits();
            } else {
                digits.add(0,new Digit(1,1L));
            }
        }
    }

    public int size() {
        return digits.size();
    }

    public long itself() {
        return numberItself;
    }

    public long getSumOfDigitPowerM() {
        long sum = 0L;
        for (Digit digit : digits) {
            sum += digit.getDigitPowerM();
        }
        return sum;
    }

    private Digit getCurrentDigit() {
        return digits.get(currentDigitIndex);
    }

    private void setCurrentDigit(Digit digit) {
        digits.set(currentDigitIndex, digit);
    }

    public ArrayList<Digit> getDigits() {
        return digits;
    }
}
