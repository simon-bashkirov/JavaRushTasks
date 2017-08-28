package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        //args=new String[5];
        //args[0] = "d:\\1.txt";
        int countOfEnglishLetters=0;

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if ((data >= 65 && data <= 90) || (data >= 97 && data <= 122)) countOfEnglishLetters++;
        /*if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            String s = new String(buffer);

            System.out.print(s);
            String[] a = s.split("\r\n");
            for (String x : a) {
                System.out.print(x + "-");
            }
            System.out.println();*/
        }
        System.out.println(countOfEnglishLetters);
        fileInputStream.close();
    }
}
