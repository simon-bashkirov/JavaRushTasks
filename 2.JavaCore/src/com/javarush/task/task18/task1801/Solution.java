package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int max_byte = 0;

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data > max_byte) max_byte = data;
        }

        fileInputStream.close();
        reader.close();

        System.out.println(max_byte);
    }
}
