package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[2];
        //args[0] = "d:\\1.txt";
        String inFile = args[0];
        HashMap<Integer, Integer> symbolCount = new HashMap<Integer, Integer>();

        FileInputStream fileInputStream = new FileInputStream(inFile);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (!(data == 10 || data == 13)) {
                if (!symbolCount.containsKey(data)) symbolCount.put(data, 1);
                else symbolCount.put(data, symbolCount.get(data) + 1);
            }
        }

        fileInputStream.close();

        ArrayList<Integer> keys = new ArrayList<Integer>(symbolCount.keySet());
        Collections.sort(keys);


        for (int key : keys) {
            System.out.println((char)key + " " + symbolCount.get(key));
        }



    }
}
