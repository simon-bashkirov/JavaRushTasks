package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int amount = 0;
        while (true) {
            ConsoleHelper.writeMessage("Please enter the withdrawal amount:");
            String s = ConsoleHelper.readString();
            try {
                amount = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(s + " is not a correct amount, please enter the withdrawal amount");
            }
            if (manipulator.isAmountAvailable(amount)) {
                break;
            } else {
                ConsoleHelper.writeMessage("There is not enough money to withdraw");
            }
        }
        Map<Integer, Integer> withdrawal = manipulator.withdrawAmount(amount);
        List<Integer> bills = new ArrayList<>(withdrawal.keySet());
        bills.sort(Comparator.reverseOrder());
        for (Integer bill : bills) {
            ConsoleHelper.writeMessage("\t" + bill + " - " + withdrawal.get(bill));
        }
    }
}
