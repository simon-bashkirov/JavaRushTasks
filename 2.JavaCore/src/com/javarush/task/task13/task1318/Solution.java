package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/*
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Throwable {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println("Enter your rollno");
        String sourceFileName=reader.readLine();
        //System.out.println(sourceFileName);

        InputStream inStream = new FileInputStream(sourceFileName);

        while (inStream.available() > 0) {
            System.out.print((char)inStream.read());
        }
        System.out.println();

        inStream.close();
        reader.close();

    }
}