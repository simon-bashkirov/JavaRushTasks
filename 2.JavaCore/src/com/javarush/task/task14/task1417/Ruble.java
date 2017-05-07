package com.javarush.task.task14.task1417;

/**
 * Created by Vitaly on 4/24/2017.
 */
public class Ruble  extends Money {
    @Override
    public String getCurrencyName() {
        return "RUB";
    }

    public Ruble(double amount) {
        super(amount);
    }
}
