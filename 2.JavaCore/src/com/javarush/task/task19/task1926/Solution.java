package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task1926.txt";
        reader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));

        while (bufferedFileReader.ready()) {
            String s = bufferedFileReader.readLine();
            String sReverse = new StringBuilder(s).reverse().toString();
            System.out.println(sReverse);
        }

        bufferedFileReader.close();
    }
}
