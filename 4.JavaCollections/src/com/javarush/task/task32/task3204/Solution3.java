package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.*;

/* 
Генератор паролей
*/
/*
public class Solution3 {
    public static final Random RANDOM = new Random();
    public static final String DIGITS = "0123456789";
    public static final String ENGLISH_LETTER_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String ENGLISH_LETTER_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        StringBuilder sb = new StringBuilder();
        sb.append(getRandomSymbol(DIGITS));
        sb.append(getRandomSymbol(ENGLISH_LETTER_LOWER));
        sb.append(getRandomSymbol(ENGLISH_LETTER_UPPER));

        for (int i = 0; i < 5; i++) {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    sb.append(getRandomSymbol(DIGITS));
                    break;
                case 1:
                    sb.append(getRandomSymbol(ENGLISH_LETTER_LOWER));
                    break;
                case 2:
                    sb.append(getRandomSymbol(ENGLISH_LETTER_UPPER));
                    break;

            }
        }

        List<Character> asciiChars = Arrays.asList(new char[][]{sb.toString().toCharArray()});

        Collections.shuffle(asciiChars);

        for (int i = 0; i < 8; i++) {
            byte b = (byte) (int) asciiChars.get(i);
            baos.write(b);
        }
        return baos;
    }

    public static String getRandomSymbol(String symbolList) {
        return String.valueOf(symbolList.charAt(RANDOM.nextInt(symbolList.length())));
    }
}*/
