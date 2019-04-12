package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command {
    @Override
    public void execute() {
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.isEmpty()) {
            ConsoleHelper.writeMessage("No money available.");
        }
        for (CurrencyManipulator manipulator : manipulators) {
            if (manipulator.hasMoney()) {
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            } else {
                ConsoleHelper.writeMessage("No money available.");
            }
        }
    }
}
