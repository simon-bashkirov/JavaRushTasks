package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        HashMap<Character, Integer> howManyLetters = new HashMap<>();

        for (int i = 0; i < abcArray.length; i++) {
            howManyLetters.put(abcArray[i],0);
        }

        for (int i = 0; i < list.size(); i++) {
            char[] curString = list.get(i).toCharArray();
            //int howManyLetters = 0;
            for (int j = 0; j < curString.length; j++) {
                char curSymbol = curString[j];
                for (int z = 0; z < abcArray.length; z++) {
                    if (curSymbol == abcArray[z]) {
                        howManyLetters.put(curSymbol,howManyLetters.get(curSymbol)+1);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < abcArray.length; i++) {
            System.out.println(abcArray[i] + " " + howManyLetters.get(abcArray[i]));
        }
    }

}
