package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[2];
//        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task1920.txt";
        String fileName = args[0];

        HashMap<String, Double> namesAndValues = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()) {
            String[] values = bufferedReader.readLine().split(" ");
            String name = values[0];
            Double valueOfAName = Double.parseDouble(values[1]);
            if (!namesAndValues.containsKey(name)) namesAndValues.put(name, valueOfAName);
            else namesAndValues.put(name, namesAndValues.get(name) + valueOfAName);
        }

        bufferedReader.close();

        ArrayList<Double> values = new ArrayList<>(namesAndValues.values());
        double maxValue = values.get(0);
        for (double f : values) {
            if (f > maxValue) maxValue = f;
        }

        for (String name : namesAndValues.keySet()) {
            if (namesAndValues.get(name) == maxValue) System.out.println(name);
        }
    }
}
