package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            arrayList.add(reader.readLine());
        }
        String shortestString = arrayList.get(0);
        int shortestStringIndex = 0;
        String longestString = arrayList.get(0);
        int longestStringIndex = 0;

        int i = 0;
        for (String string : arrayList) {
            if (string.length() < shortestString.length()) {
                shortestString = string;
                shortestStringIndex = i;

            } else if (string.length() > longestString.length()) {
                longestString = string;
                longestStringIndex = i;
            }
            i++;
        }

        System.out.println(shortestStringIndex < longestStringIndex ? shortestString : longestString);

        reader.close();
    }
}
