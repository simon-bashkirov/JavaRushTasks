package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int min_byte = 0;

        if (fileInputStream.available() > 0) min_byte =  fileInputStream.read();

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data < min_byte) min_byte = data;
        }

        fileInputStream.close();
        reader.close();

        System.out.println(min_byte);
    }
}
