package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
//        String fileName1 = "D:\\dev\\JavaRushTasks\\source_files\\task1909\\1.txt";
//        String fileName2 = "D:\\dev\\JavaRushTasks\\source_files\\task1909\\2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        while (bufferedReader.ready()) {
            int data = bufferedReader.read();
            if (data == 46) data = 33;
            bufferedWriter.write(data);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
