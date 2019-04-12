package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        denominations.compute(denomination, (k, v) -> v == null ? count : v + count);
    }

    public int getTotalAmount() {
        return denominations.entrySet().stream()
                .mapToInt(e -> e.getKey() * e.getValue())
                .sum();
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) {
        Map<Integer, Integer> withdrawal = new HashMap<>();

        List<Integer> denominationsList = new LinkedList<>(denominations.keySet());
        denominationsList.sort(Collections.reverseOrder());
        while (expectedAmount > 0 && !denominationsList.isEmpty()) {
            int nextBiggestFaceValue = denominationsList.get(0);
            if (nextBiggestFaceValue < expectedAmount) {
                int expectedAmountOfBills = expectedAmount / nextBiggestFaceValue;
                Integer actualAmountOfBills = denominations.get(nextBiggestFaceValue);
                if (expectedAmountOfBills < actualAmountOfBills) {
                    denominations.put(nextBiggestFaceValue, actualAmountOfBills - expectedAmountOfBills);
                    withdrawal.put(nextBiggestFaceValue, expectedAmountOfBills);
                    expectedAmount -= nextBiggestFaceValue * expectedAmountOfBills;
                } else {
                    denominations.remove(nextBiggestFaceValue);
                    withdrawal.put(nextBiggestFaceValue, actualAmountOfBills);
                    expectedAmount -= nextBiggestFaceValue * actualAmountOfBills;
                }
            } else {
                denominationsList.remove(0);
            }
        }

        return withdrawal;
    }
}
