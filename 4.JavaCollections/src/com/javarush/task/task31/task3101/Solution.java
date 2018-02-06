package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[2];
        String path = args[0];// = "D:\\dev\\JavaRushTasks\\source_files\\task3101";
        String resultFileAbsolutePath = args[1];// = "D:\\dev\\JavaRushTasks\\source_files\\task3101\\1.txt";

        TreeMap<String, File> fileTreeMap = new TreeMap<>();
        File filePath = new File(path);

        findFiles(filePath, fileTreeMap);

        File allFilesContent = new File(resultFileAbsolutePath);
        File newPath = new File(allFilesContent.getParentFile().getAbsolutePath() + "/allFilesContent.txt");
        if (!FileUtils.isExist(allFilesContent)) allFilesContent.createNewFile();

        FileUtils.renameFile(allFilesContent, newPath);
//        allFilesContent = newPath;

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(allFilesContent));

        for (File file : fileTreeMap.values()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int count = fileInputStream.read(buffer);
//                System.out.println(file.getAbsolutePath());
//                System.out.println(buffer.toString());
                bufferedWriter.write(new String(buffer, StandardCharsets.UTF_8));
                bufferedWriter.newLine();
            }
            fileInputStream.close();
        }

        bufferedWriter.close();
    }

    public static void findFiles(File filePath, TreeMap<String, File> fileTreeMap) {
        for (File file : Objects.requireNonNull(filePath.listFiles())) {
            if (file.isFile()) {
                if (file.length() <= 50) fileTreeMap.put(file.getName(), file);
            } else {
                findFiles(file, fileTreeMap);
            }
        }
    }
}
