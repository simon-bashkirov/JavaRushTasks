package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
    public static char[] consonants = new char[]{'б', 'в', 'г', 'д', 'ж', 'з', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', '.', ',', '-'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] s_split = s.toCharArray();
        for (int i = 0; i < s_split.length; i++) {
            char c = s_split[i];
            if(isVowel(c)) System.out.print(c + " ");
        }
        System.out.println();
        for (int i = 0; i < s_split.length; i++) {
            char c = s_split[i];
            if(isConsonantOrSign(c)) System.out.print(c + " ");
        }
        System.out.println();
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }

    public static boolean isConsonantOrSign(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : consonants)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}