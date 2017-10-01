package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[2];
//        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task1919.txt";
        String fileName = args[0];

        HashMap<String, Float> namesAndValues = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()) {
            String[] values = bufferedReader.readLine().split(" ");
            String name = values[0];
            Float valueOfAName = Float.parseFloat(values[1]);
            if (!namesAndValues.containsKey(name)) namesAndValues.put(name, valueOfAName);
            else namesAndValues.put(name, namesAndValues.get(name) + valueOfAName);
        }

        bufferedReader.close();

        ArrayList<String> keys = new ArrayList<>(namesAndValues.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            System.out.println(key + " " + namesAndValues.get(key));
        }
    }
}
