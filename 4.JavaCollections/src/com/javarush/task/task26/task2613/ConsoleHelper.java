package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static final Pattern TWO_NUMBERS = Pattern.compile("^[1-9]\\d+\\s[1-9]\\d+$");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String text = null;
        try {
            text = bis.readLine();
        } catch (IOException ignored) {
        }
        return text;
    }

    public static String askCurrencyCode() {
        ConsoleHelper.writeMessage("Введите код валюты состоящий из 3х символов:");

        String code = "";

        while(true) {
            try {
                code = bis.readLine();
                if (code.length() == 3) {
                    break;
                } else {
                    ConsoleHelper.writeMessage("Код валюты должен состоять из 3 символов");
                }
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        ConsoleHelper.writeMessage("Выбранная валюта - " + currencyCode + ", введите номинал и количество банкнот через пробел:");

        String[] faceValueAndAmount = null;
        int numTries = 3;

        while(numTries-- > 0) {
            try {
                String s = bis.readLine();
                if (TWO_NUMBERS.matcher(s).matches()) {
                    faceValueAndAmount = s.split(" ");
                    break;
                } else {
                    ConsoleHelper.writeMessage("Вы ввели некорректные данные, введите номинал и количество банкнот через пробел:");
                }
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return faceValueAndAmount;
    }
}
