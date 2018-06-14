package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws Exception {
        String fileName = args[0];
        int pos = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(pos);
            int length = text.length();
            byte[] buffer = new byte[length];
            raf.read(buffer, 0, length);
            String readText = new String(buffer);

            raf.seek(raf.length());
            raf.write((text.equals(readText) ? "true" : "false").getBytes());
        }
    }
}
