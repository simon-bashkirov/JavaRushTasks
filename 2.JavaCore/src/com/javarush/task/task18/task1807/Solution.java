package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int countOfCommas = 0;

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data == 44) countOfCommas++;
        }
        System.out.println(countOfCommas);

        fileInputStream.close();
        reader.close();

        //System.out.println(min_byte);

    }
}
