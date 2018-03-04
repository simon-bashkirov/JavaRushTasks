package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[4];
//        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\result.pdf";
//        args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\z.zip.001";
//        args[2] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\z.zip.002";
//        args[3] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\z.zip.003";

        String resultFileName = args[0];
        Map<String, FileInputStream> zipParts = new TreeMap<>();
        for (int i = 1; i < args.length; i++) {
            zipParts.put(args[i], new FileInputStream(args[i]));
        }

        byte[] buffer = new byte[1024*10];


        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(zipParts.values()));
                ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
                FileOutputStream fos = new FileOutputStream(resultFileName)
        ) {
            ZipEntry nextEntry;
            while ((nextEntry = zipInputStream.getNextEntry()) != null) {
                int len;
                while ((len = zipInputStream.read(buffer)) > 0)
                    fos.write(buffer, 0, len);
                zipInputStream.closeEntry();
            }
        }

    }
}
