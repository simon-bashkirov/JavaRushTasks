package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);

        byte[] buffer1 = new byte[fileInputStream1.available()];
        int count1 = fileInputStream1.read(buffer1);
        byte[] buffer2 = new byte[fileInputStream2.available()];
        int count2 = fileInputStream2.read(buffer2);
        fileInputStream1.close();
        fileInputStream2.close();

        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
        fileOutputStream1.write(buffer2,0,count2);
        fileOutputStream1.write(buffer1,0,count1);

        fileOutputStream1.close();


    }
}
