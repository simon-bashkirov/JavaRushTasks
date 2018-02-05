package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();

        while (true) {
            int id = 0;
            String s = reader.readLine();
            if (s.isEmpty()) break;
            else id = Integer.parseInt(s);
            String name = reader.readLine();
            if (name.isEmpty()) break;
            else hashMap.put(name, id);
        }

        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }

        reader.close();
    }
}
