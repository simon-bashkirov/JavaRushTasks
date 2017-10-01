package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[2];
//        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task1925\\1.txt";
//        args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task1925\\2.txt";
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileName2));

        boolean firstMatchFound = false;
        while(bufferedFileReader.ready()) {
            String stringToAppend = "";
            String[] words = bufferedFileReader.readLine().split(" ");
            for (String w : words) {
                if (w.length() > 6) {
                    if (firstMatchFound) stringToAppend += ",";
                    stringToAppend += w;
                    firstMatchFound = true;
                }
            }
            bufferedFileWriter.write(stringToAppend);
        }

        bufferedFileReader.close();
        bufferedFileWriter.close();

    }
}
