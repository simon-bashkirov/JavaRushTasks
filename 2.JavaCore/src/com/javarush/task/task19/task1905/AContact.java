package com.javarush.task.task19.task1905;

public class AContact implements Solution.Contact {
    @Override
    public String getPhoneNumber() {
        return "+38(050)123-45-67";
    }

    @Override
    public String getName() {
        return "Ivanov, Ivan";
    }
}
