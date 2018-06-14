package com.javarush.task.task32.task3201;

import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws Exception {
        String fileName = args[0];
        int pos = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            long len = raf.length();
            raf.seek(pos <= len ? pos : len);
            raf.write(text.getBytes());
        }
    }
}
