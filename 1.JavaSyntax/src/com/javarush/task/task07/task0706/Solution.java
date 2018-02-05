package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] houses = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inhabitantsOnEvenSide = 0;
        int inhabitantsOnOddSide = 0;
        for (int i = 0; i < 15; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
            if (i == 0 || i % 2 == 0) inhabitantsOnEvenSide += houses[i];
            else inhabitantsOnOddSide += houses[i];
        }

        System.out.println("В домах с " +
                (inhabitantsOnOddSide > inhabitantsOnEvenSide ? "не" : "" ) +
                "четными номерами проживает больше жителей."
        );

        reader.close();
    }
}
