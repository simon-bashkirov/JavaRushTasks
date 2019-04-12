package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

public interface Command {
    void execute() throws InterruptOperationException;
}
