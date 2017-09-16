package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static boolean readDigitSequence = true;
    public static final int SPACE = 32;
    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = reader.readLine();
//        String fileName2 = reader.readLine();
//        reader.close();
        String fileName1 = "D:\\dev\\JavaRushTasks\\source_files\\task1908\\1.txt";
        String fileName2 = "D:\\dev\\JavaRushTasks\\source_files\\task1908\\2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        String aNumber = "";
        while (bufferedReader.ready()) {
            int data = bufferedReader.read();
            //System.out.print(data + " ");
            if (isNewLine(data)) {
                bufferedReader.read();
            }
            if (readDigitSequence) {
                if (isSymbolADigit(data)) aNumber += (char)data;
                else if (data == SPACE) {
                    System.out.println(aNumber + " ");
                    aNumber = "";
                } else {
                    readDigitSequence = false;
                }
            } else if (data == SPACE) readDigitSequence = true;
            else if (isNewLine(data)) {
                bufferedReader.read();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();

    }

    public class ANumber {

    }

    public static boolean isSymbolADigit(int a) {
        return a >= 48 && a <= 57;
    }

    public static boolean isNewLine(int a) {
        return a == 13 || a == 10;
    }
}
