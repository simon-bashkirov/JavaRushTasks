package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[2];
//        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task3105\\result.txt";
//        args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task3105\\test.zip";
        String fileName = args[0];
        String zipName = args[1];

        Map<ZipEntry, ByteArrayOutputStream> mapOfByteContent = new HashMap<>();

        byte[] buffer = new byte[1024];

        try (FileInputStream zipFis = new FileInputStream(zipName);
                ZipInputStream zipInputStream = new ZipInputStream(zipFis);
        ) {
            ZipEntry nextEntry;
            while ((nextEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int len;
                while ((len = zipInputStream.read(buffer)) > 0)
                    byteArrayOutputStream.write(buffer, 0, len);
                byteArrayOutputStream.close();
                mapOfByteContent.put(nextEntry, byteArrayOutputStream);
                zipInputStream.closeEntry();
        }

        }

        try (FileOutputStream zipFos = new FileOutputStream(zipName);
             ZipOutputStream zipOutputStream = new ZipOutputStream(zipFos);
        ) {
            Path pathToZip = Paths.get(fileName);
            zipOutputStream.putNextEntry(new ZipEntry("new/"  + pathToZip.getFileName().toString()));
            Files.copy(pathToZip, zipOutputStream);
            zipOutputStream.closeEntry();

            for (Map.Entry<ZipEntry, ByteArrayOutputStream> entry : mapOfByteContent.entrySet()) {
                zipOutputStream.putNextEntry(entry.getKey());
                zipOutputStream.write(entry.getValue().toByteArray());
                zipOutputStream.closeEntry();
            }
        }

    }
}
