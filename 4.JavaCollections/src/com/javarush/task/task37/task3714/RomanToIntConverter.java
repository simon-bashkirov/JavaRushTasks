package com.javarush.task.task37.task3714;

public class RomanToIntConverter implements NumberConverter {

    @Override
    public int convert(String number) {
        int intValue = RomanNumerals.getIntValueByString(number.charAt(0));;
        if (number.length() == 1) {
            return intValue;
        }

        for (int i = 1; i < number.length(); i++) {
            char c = number.charAt(i);

        }
        return intValue;
    }
}
