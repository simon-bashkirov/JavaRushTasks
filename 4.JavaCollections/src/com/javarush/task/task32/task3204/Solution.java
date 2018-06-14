package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        List<Integer> asciiChars = new ArrayList<>();
        asciiChars.add(RandomChar.DIGIT.get());
        asciiChars.add(RandomChar.ENGLISH_LETTER_LOWER.get());
        asciiChars.add(RandomChar.ENGLISH_LETTER_UPPER.get());

        for (int i = 0; i < 5; i++) {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    asciiChars.add(RandomChar.DIGIT.get());
                    break;
                case 1:
                    asciiChars.add(RandomChar.ENGLISH_LETTER_LOWER.get());
                    break;
                case 2:
                    asciiChars.add(RandomChar.ENGLISH_LETTER_UPPER.get());
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

    public enum RandomChar {
        DIGIT {
            @Override
            public int get() {
                return 48 + RANDOM.nextInt(10);
            }
        },
        ENGLISH_LETTER_UPPER {
            @Override
            public int get() {
                return 65 + RANDOM.nextInt(26);
            }
        },
        ENGLISH_LETTER_LOWER {
            @Override
            public int get() {
                return 97 + RANDOM.nextInt(26);
            }
        };

        public final Random RANDOM = new Random();

        public abstract int get();
    }
}