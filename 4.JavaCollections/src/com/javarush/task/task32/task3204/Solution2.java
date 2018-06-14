package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution2 {

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        List<Integer> asciiChars = new ArrayList<>();
        asciiChars.add(RandomChar.getDigit());
        asciiChars.add(RandomChar.getEnglishLetterLower());
        asciiChars.add(RandomChar.getEnglishLetterUpper());

        for (int i = 0; i < 5; i++) {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    asciiChars.add(RandomChar.getDigit());
                    break;
                case 1:
                    asciiChars.add(RandomChar.getEnglishLetterLower());
                    break;
                case 2:
                    asciiChars.add(RandomChar.getEnglishLetterUpper());
                    break;

            }
        }

        Collections.shuffle(asciiChars);

        for (int i = 0; i < 8; i++) {
            byte b = (byte) (int) asciiChars.get(i);
            baos.write(b);
        }
        return baos;
    }

    public static class RandomChar {
        public static final Random RANDOM = new Random();

        public static int getDigit() {
            return 48 + RANDOM.nextInt(10);
        }

        public static int getEnglishLetterUpper() {
            return 65 + RANDOM.nextInt(26);
        }

        public static int getEnglishLetterLower() {
            return 97 + RANDOM.nextInt(26);
        }
    }
}