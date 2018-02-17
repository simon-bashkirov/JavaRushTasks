package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static List<File> files;

    public static void main(String[] args) throws IOException {
//        args = new String[2];
//        String path = args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task3101";
//        String resultFileAbsolutePath = args[1] = "D:\\dev\\JavaRushTasks\\source_files\\task3101\\1.txt";
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File filePath = new File(path);

        File allFilesContent = new File(resultFileAbsolutePath);
        File newPath = new File(allFilesContent.getParentFile().getAbsolutePath() + "\\allFilesContent.txt");
//        System.out.println(newPath);
        if (!FileUtils.isExist(allFilesContent)) allFilesContent.createNewFile();

        FileUtils.renameFile(allFilesContent, newPath);
        allFilesContent = newPath;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(allFilesContent))) {
            files = findFiles(filePath);
            files.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            writeToAllFilesContent(allFilesContent, bufferedWriter);
        }


    }

    public static List<File> findFiles(File filePath) {
        Queue<File> fileQueue = new LinkedList<>(Arrays.asList(filePath.listFiles()));
        List<File> listOfFiles = new ArrayList<>();

        while (fileQueue.size() > 0) {
            File file = fileQueue.remove();
            if (file.isDirectory()) {
                fileQueue.addAll(Arrays.asList(file.listFiles()));
            } else if (!(file.length() > 50))
                listOfFiles.add(file);
        }

        return listOfFiles;
    }

    public static void writeToAllFilesContent(File allFilesContent, BufferedWriter bufferedWriter) throws IOException {

        for (File file : files) {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int count = fileInputStream.read(buffer);;
                bufferedWriter.write(new String(buffer, StandardCharsets.UTF_8));
                bufferedWriter.newLine();
            }
            fileInputStream.close();
        }

    }
}
