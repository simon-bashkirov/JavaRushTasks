package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[2];
//        args[0] = "D:\\dev\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2211\\example.txt";
//        args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task2211\\1.txt";

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        String s = "";

        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            s = new String(buffer,"Windows-1251");
        }

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        fileOutputStream.write(s.getBytes("UTF8"));

        fileOutputStream.close();
    }
}
