package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution_split {
    public static final int SPACE = 32;

    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = reader.readLine();
//        String fileName2 = reader.readLine();
//        reader.close();
        String fileName1 = "D:\\dev\\JavaRushTasks\\source_files\\task1908\\1.txt";
        String fileName2 = "D:\\dev\\JavaRushTasks\\source_files\\task1908\\2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        while (bufferedReader.ready()) {
            String[] words = bufferedReader.readLine().split(" ");
            for (String s : words) {
                try {
                    int aNumber = Integer.parseInt(s);
                    bufferedWriter.write(s);
                    bufferedWriter.write(SPACE);
                } catch (NumberFormatException ignored) {}
            }
        }


        bufferedReader.close();
        bufferedWriter.close();

    }

}
