package com.javarush.task.task31.task3105;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[2];
        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task3105\\result.txt";
        args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task3105\\test.zip";
        String fileName = args[0];
        String zipName = args[1];

        List<ZipEntry> zipEntries = new ArrayList<>();

        FileInputStream zipFis = new FileInputStream(zipName);
        ZipInputStream zipInputStream = new ZipInputStream(zipFis);
        while (zipInputStream.available() > 0) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null)
                zipEntries.add(nextEntry);
        }

        zipInputStream.close();
        zipFis.close();

        System.out.println(zipEntries);

        FileOutputStream zipFos = new FileOutputStream(zipName);
        ZipOutputStream zipOutputStream = new ZipOutputStream(zipFos);

        zipOutputStream.putNextEntry(new ZipEntry(fileName));
        for (ZipEntry zipEntry : zipEntries) {
            zipOutputStream.putNextEntry(zipEntry);
        }

        zipOutputStream.close();
        zipFos.close();
    }
}
