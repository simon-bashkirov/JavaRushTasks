package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task1924.txt";
        reader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));

        while (bufferedFileReader.ready()) {
            String[] words = bufferedFileReader.readLine().split(" ");
            String outputLine = "";
            for (String w : words) {
                if (w.matches("[0-9]+")) {
                    int i = Integer.parseInt(w);
                    if (i >= 0 && i <= 12) w = map.get(i);
                }
                outputLine += w + " ";
            }
            System.out.println(outputLine);
        }

        bufferedFileReader.close();
    }
}
