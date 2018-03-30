package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedList;

public class Number {
    private ArrayList<Digit> digits = new ArrayList<>();
    private ArrayList<Long> digitsSums = new ArrayList<>();
    private int currentDigitIndex;
    private long numberItself;

    public Number () {
        digits.add(new Digit(this));
        digitsSums.add(0L);
    }

    public Number (long number) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (number > 0) {
            stack.push( (int)number % 10 );
            number = number / 10;
        }

        while (!stack.isEmpty()) {
            digits.add(new Digit(stack.pop()));
        }
    }

    public void increment() {
        increment(getRightmostDigitIndex()); // increment starting rightmost digit
    }

    public void increment(int index) {
        currentDigitIndex = index;
        numberItself++;
        incrementDigits();
    }

    public void shiftIndexAndIncrement() {
        currentDigitIndex = getRightmostDigitIndex()-1;
        getCurrentDigit().setToZero();
        increment(--currentDigitIndex);
    }

    private void incrementDigits() {
        if (getCurrentDigit().getDigit() < 9) {
            long sum = digitsSums.get(currentDigitIndex) - getCurrentDigit().getDigitPowerM();
            getCurrentDigit().increment();
            sum += getCurrentDigit().getDigitPowerM();
            repopulateSumOfPowerMForZeros(sum);

        } else {
            getCurrentDigit().setToZero();
            if (currentDigitIndex > 0) {
                currentDigitIndex--;
                incrementDigits();
            } else {
                digits.add(0,new Digit(1,1L, this));
                /*START of new code to repopulate array with sums*/
                Digit.populateMatrixOfPowers(size());
                digitsSums.add(0, 1L);
                for (int i = 1; i < digitsSums.size(); i++) {
                    digitsSums.set(i, digitsSums.get(i-1) + digits.get(i).getDigitPowerM());
                }
                /*END*/
            }
        }
    }

    public int size() {
        return digits.size();
    }

    public long itself() {
        return numberItself;
    }

    public void repopulateSumOfPowerMForZeros(long sum) {
        for (int i = currentDigitIndex; i < size(); i++) {
            digitsSums.set(i, sum);
        }
    }

    public void repopulateSumOfPowerMForAll() {
        long sum = 0L;
        int i = 0;
        for (Digit digit : digits) {
            sum += digit.getDigitPowerM();
            digitsSums.set(i++, sum);
        }
    }

    public long recalculateNumberItself() {
        long newNum = 0L;
        for (int i = 0; i < digits.size(); i++) {
            newNum += digits.get(i).getDigit()*((long)Math.pow(10,digits.size()-1-i));
        }
        return newNum;
    }

    public long getSumOfDigitPowerM() {
        /*long sum = 0L;
        for (Digit digit : digits) {
            sum += digit.getDigitPowerM();
        }
        return sum;*/
        return digitsSums.get(size()-1);
    }

    public int getRightmostDigitIndex() {
        return digits.size()-1;
    }

    private Digit getCurrentDigit() {
        return digits.get(currentDigitIndex);
    }

    public ArrayList<Digit> getDigits() {
        return digits;
    }

}
