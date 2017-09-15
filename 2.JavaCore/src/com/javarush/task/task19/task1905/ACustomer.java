package com.javarush.task.task19.task1905;

public class ACustomer implements Solution.Customer {
    @Override
    public String getCountryName() {
        return "Ukraine";
    }

    @Override
    public String getCompanyName() {
        return "JavaRush Ltd.";
    }
}
