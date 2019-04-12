package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

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
}
