package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[5];
        //args[0] = "d:\\1.txt";
        float countOfSpaces = 0;
        float countOfAllSymbols = 0;

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data == 32) {
                countOfSpaces++;
                countOfAllSymbols++;
            }
            else countOfAllSymbols++;
        }
        float proportion = Math.round(countOfSpaces/countOfAllSymbols*100*100)/100f;
        //System.out.println("countOfSpaces " + countOfSpaces);
        //System.out.println("countOfAllSymbols " + countOfAllSymbols);
        System.out.println(proportion);

        fileInputStream.close();
    }
}
