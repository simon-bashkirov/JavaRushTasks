package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

import static com.javarush.task.task26.task2613.Operation.DEPOSIT;
import static com.javarush.task.task26.task2613.Operation.EXIT;
import static com.javarush.task.task26.task2613.Operation.INFO;
import static com.javarush.task.task26.task2613.Operation.WITHDRAW;

public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    static {
        allKnownCommandsMap.put(INFO, new InfoCommand());
        allKnownCommandsMap.put(DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(EXIT, new ExitCommand());
    }

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        allKnownCommandsMap.get(operation).execute();
    }
}
