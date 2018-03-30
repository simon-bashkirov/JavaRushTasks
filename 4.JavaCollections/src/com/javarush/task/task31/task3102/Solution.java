package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDirectory = new File(root);
        Queue<File> fileQueue = new LinkedList<>(Arrays.asList(rootDirectory.listFiles()));
        List<String> listOfFiles = new ArrayList<>();
        while (fileQueue.size() > 0) {
            File file = fileQueue.remove();
            if (file.isDirectory()) {
                fileQueue.addAll(Arrays.asList(file.listFiles()));
            } else
                listOfFiles.add(file.getAbsolutePath());
        }
        return listOfFiles;
    }

    public static void main(String[] args) throws IOException {
//        args = new String[1];
//        String root = args[0] = "D:\\dev\\JavaRushTasks\\4.JavaCollections";
        String root = args[0];
        List<String> fileTree = getFileTree(root);
        for (String string : fileTree) {
            System.out.println(string);
        }
    }
}
