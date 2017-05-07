package com.javarush.task.task14.task1417;

/**
 * Created by Vitaly on 4/24/2017.
 */
public class Hrivna  extends Money {
    @Override
    public String getCurrencyName() {
        return "HRN";
    }

    public Hrivna(double amount) {
        super(amount);
    }
}
