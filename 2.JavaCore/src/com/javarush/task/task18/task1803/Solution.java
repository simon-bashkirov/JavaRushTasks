package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxRepeatCount = 0;
        ArrayList<Integer> maxBytes = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        HashMap<Integer, Integer> bytesCount = new HashMap<Integer, Integer>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (bytesCount.get(data) == null) bytesCount.put(data, 1);
            else bytesCount.put(data, bytesCount.get(data)+1);
        }

        fileInputStream.close();
        reader.close();

        for (HashMap.Entry<Integer, Integer> entry : bytesCount.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > maxRepeatCount) {
                maxRepeatCount = value;
                maxBytes.clear();
                maxBytes.add(key);
            } else if (value == maxRepeatCount) maxBytes.add(key);
        }

        for (Integer i : maxBytes) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
