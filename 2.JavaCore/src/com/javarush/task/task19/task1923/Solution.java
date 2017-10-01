package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[2];
//        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task1923\\1.txt";
//        args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task1923\\2.txt";
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileName2));

        while (bufferedFileReader.ready()) {
//            boolean containsAnymatches = false;
            String[] words = bufferedFileReader.readLine().split(" ");
            for (String s : words) {
                if (s.matches(".*[0-9].*")) {
//                    containsAnymatches = true;
                    bufferedFileWriter.write(s + " ");
                }
            }
//            if (containsAnymatches) bufferedFileWriter.newLine();
        }

        bufferedFileReader.close();
        bufferedFileWriter.close();
    }
}
