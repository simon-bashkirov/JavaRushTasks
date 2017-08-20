package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int minRepeatCount;
        ArrayList<Integer> minBytes = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        HashMap<Integer, Integer> bytesCount = new HashMap<Integer, Integer>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (!bytesCount.containsKey(data)) bytesCount.put(data, 1);
            else bytesCount.put(data, bytesCount.get(data)+1);
        }

        minRepeatCount = bytesCount.size();

        fileInputStream.close();
        reader.close();

        for (HashMap.Entry<Integer, Integer> entry : bytesCount.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value < minRepeatCount) {
                minRepeatCount = value;
                minBytes.clear();
                minBytes.add(key);
            } else if (value == minRepeatCount) minBytes.add(key);
        }

        for (Integer i : minBytes) {
            System.out.print(i + " ");
        }
        System.out.println();


    }
}
