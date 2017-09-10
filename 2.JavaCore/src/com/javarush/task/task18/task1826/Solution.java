package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[3];
//        args[0] = "-d";
//        args[1] = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task1826\\2.txt";
//        args[2] = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task1826\\3.txt";
        String argument = args[0];
        String sourceFile = args[1];
        String outputFile = args[2];

//        int data = 111;
//        System.out.println(data);
//        System.out.println(encode(data));
//        System.out.println(decode(encode(data)));

        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (argument.equals("-e")) data = encode(data);
            else if (argument.equals("-d")) data = decode(data);
            fileOutputStream.write(data);
        }

        fileOutputStream.close();
        fileInputStream.close();

    }

    public static int encode(int data) {
        if (data <= 96 && data >= 32) data += 30;
        else if (data >= 97){
//            System.out.println("debug " + (126-data));
//            System.out.println("debug " + (30-(126-data)));
//            System.out.println("debug " + (32+(30-(126-data))));
            data = 32+(30-(126-data));
        }
        return data;
    }

    public static int decode(int data) {
        if (data >= 62) data -= 30;
        else if (data > 32) {
            data = 126-(30-(data-32));
        }
        return data;
    }

}
