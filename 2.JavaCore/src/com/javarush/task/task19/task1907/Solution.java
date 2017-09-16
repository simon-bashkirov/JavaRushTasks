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

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//        reader.close();
        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task1907.txt";



        FileReader fileReader = new FileReader(fileName);

        while (fileReader.ready()) {
            int data = fileReader.read();
            //System.out.println("int: " + data + ",(char): " + (char)data );
            System.out.print((char)data + " ");

        }

        fileReader.close();

//        char c = 'a';
//        char.isLetter()
//        String word = "world";
//        word.toCharArray();

    }

    public static class CharArray {
        char[] charArray;

        public CharArray() {
            this.charArray = new char[1];
        }

        public void add(char ch) {
            charArray[charArray.length-1] = ch;
            char[] tmpCharAray = new char[charArray.length+1];
            for (int i = 0; i < charArray.length; i++) tmpCharAray[i] = charArray[i];
            charArray = tmpCharAray;
        }

        public char[] getCharArray() {
            return charArray;
        }
    }
}
