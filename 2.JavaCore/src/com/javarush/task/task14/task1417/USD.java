package com.javarush.task.task14.task1417;

/**
 * Created by Vitaly on 4/24/2017.
 */
public class USD  extends Money {
    @Override
    public String getCurrencyName() {
        return "USD";
    }

    public USD(double amount) {
        super(amount);
    }
}
