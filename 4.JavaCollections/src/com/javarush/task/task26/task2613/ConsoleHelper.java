package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static final Pattern TWO_NUMBERS = Pattern.compile("^[1-9]\\d*\\s[1-9]\\d*$");

    public static void main(String[] args) {
        for (Operation value : Operation.values()) {
            System.out.println(value + " " + value.ordinal());
        }
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String text = null;
        try {
            text = bis.readLine();
        } catch (IOException ignored) {
        }
        if ("EXIT".equalsIgnoreCase(text)) {
            throw new InterruptOperationException();
        }
        return text;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Введите код валюты состоящий из 3х символов:");

        String code = "";

        while(true) {
            code = readString();
            if (code.length() == 3) {
                break;
            } else {
                ConsoleHelper.writeMessage("Код валюты должен состоять из 3 символов");
            }
        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        ConsoleHelper.writeMessage("Выбранная валюта - " + currencyCode + ", введите номинал и количество банкнот через пробел:");

        String[] faceValueAndAmount = null;
        int numTries = 3;

        while(numTries-- > 0) {
            String s = readString();
            if (TWO_NUMBERS.matcher(s).matches()) {
                faceValueAndAmount = s.split(" ");
                break;
            } else {
                ConsoleHelper.writeMessage("Вы ввели некорректные данные, введите номинал и количество банкнот через пробел:");
            }
        }

        return faceValueAndAmount;
    }

    public static Operation askOperation() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Введите номер операции:\n\t1 - INFO\n\t2 - DEPOSIT\n\t3 - WITHDRAW\n\t4 -  EXIT");

        Operation operation = null;

        while(true) {
            try {
                String s = readString();
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
                break;
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Введите номер операции:\n\t1 - INFO\n\t2 - DEPOSIT\n\t3 - WITHDRAW\n\t4 -  EXIT");
            }
        }

        return operation;
    }
}
