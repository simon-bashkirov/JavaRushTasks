package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Are you sure you want to exit? y/n");
        if (ConsoleHelper.readString().equals("y")) {
            ConsoleHelper.writeMessage("Thank you for using our system, good bye!");
        }
    }
}
