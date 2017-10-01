package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    public static final int MaxMatchCount = 2;

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            String[] wordsAtCurrentLine = s.split(" ");
            int howManyWordsMatch = 0;
            for (String w : wordsAtCurrentLine) {
                if (howManyWordsMatch == 3) break;
                if (words.contains(w)) howManyWordsMatch++;// System.out.println("match");
            }
            if (howManyWordsMatch == 2) System.out.println(s);
        }

        bufferedReader.close();
    }
}
