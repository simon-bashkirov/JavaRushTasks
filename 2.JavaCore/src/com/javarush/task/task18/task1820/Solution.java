package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static final int SPACE = 32;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        //String file1 = "d:\\1.txt";
        //String file2 = "d:\\2.txt";
        String fileContent = null;

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);

        if (fileInputStream1.available() > 0) {
            //int data = fileInputStream1.read();
            //String s = new String(data, StandardCharsets.UTF_8);
            byte[] buffer = new byte[fileInputStream1.available()];
            int count = fileInputStream1.read(buffer);
            fileContent = new String(buffer, StandardCharsets.UTF_8);
            //System.out.print(s + " ");
        }
        String[] numbers = fileContent.split(" ");

        for (String aNumber : numbers) {
            float aFloat = Float.parseFloat(aNumber);
            Integer roundedInt = Math.round(aFloat);
            //System.out.println(roundedInt);
            byte[] intToBytes = roundedInt.toString().getBytes();
            fileOutputStream2.write(intToBytes);
            fileOutputStream2.write(SPACE);
        }

        fileInputStream1.close();
        fileOutputStream2.close();

    }
}
