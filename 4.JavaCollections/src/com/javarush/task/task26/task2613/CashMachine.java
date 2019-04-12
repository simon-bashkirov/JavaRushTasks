package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] validTwoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulator.addAmount(Integer.parseInt(validTwoDigits[0]), Integer.parseInt(validTwoDigits[1]));
        ConsoleHelper.writeMessage("" + manipulator.getTotalAmount());
    }
}
