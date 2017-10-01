package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
//    public static final char[] punctuationMarks = {'',''};
    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = reader.readLine();
//        String fileName2 = reader.readLine();
//        reader.close();
        String fileName1 = "D:\\dev\\JavaRushTasks\\source_files\\task1910\\1.txt";
        String fileName2 = "D:\\dev\\JavaRushTasks\\source_files\\task1910\\2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        while (bufferedReader.ready()) {
            int data = bufferedReader.read();
            String s = String.valueOf((char)data);
            if (!(s.matches("\\p{Punct}") || data == 13 || data == 10)) {
//                System.out.print(s);
                bufferedWriter.write(data);
            }
        }
//        System.out.println();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean isAPunctuationMark(int a) {
        return true;
    }
}
