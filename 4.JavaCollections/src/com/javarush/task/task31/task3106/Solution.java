package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[4];
        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\result.pdf";
        args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\z.zip.001";
        args[2] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\z.zip.002";
        args[3] = "D:\\dev\\JavaRushTasks\\source_files\\task3106\\z.zip.003";

        String resultFileName = args[0];
        String[] fileNamePart = new String[args.length-1];
        for (int i = 1; i < args.length; i++) {
            fileNamePart[i-1] = args[i];
        }

        Arrays.sort(fileNamePart);

        byte[] buffer = new byte[1024*10];

        try (FileOutputStream fos = new FileOutputStream(resultFileName)) {
            for (String fileName : fileNamePart) {
                try (FileInputStream zipFis = new FileInputStream(fileName);
                     ZipInputStream zipInputStream = new ZipInputStream(zipFis);
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
    }
}
