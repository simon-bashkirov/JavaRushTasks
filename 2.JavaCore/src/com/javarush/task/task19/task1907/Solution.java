package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String word = "world";
    public static int countOfWord = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
//        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task1907.txt";



        FileReader fileReader = new FileReader(fileName);

        String currentWord = "";
        while (fileReader.ready()) {
            int data = fileReader.read();
            char ch = (char)data;
            if (Character.isLetter(ch)) {
                currentWord += ch;
            } else {
                if (currentWord.equals(word)) countOfWord++;
                currentWord = "";
            }

        }

        fileReader.close();

        System.out.println(countOfWord);

    }

}
