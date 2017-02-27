package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String[] s_split = s.split(" ");
        for (int i = 0; i < s_split.length; i++) {
            String[] i_s = s_split[i].split("");
            i_s[0] = i_s[0].toUpperCase();
            String uString = String.join("", i_s);
            System.out.print(uString + " ");
        }
        System.out.println();
    }
}
