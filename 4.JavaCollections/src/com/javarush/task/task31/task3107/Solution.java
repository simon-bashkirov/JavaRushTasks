package com.javarush.task.task31.task3107;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        if (Files.exists(path)) {
            fileData = new ConcreteFileData(Files.isHidden(path), Files.isExecutable(path), Files.isDirectory(path), Files.isWritable(path));
        } else {
            fileData = new NullFileData(new FileNotFoundException("File " + pathToFile + " does not exist"));
        }
    }

    public static void main(String[] args) throws IOException {
        String pathToFile = "D:\\dev\\JavaRushTasks\\source_files\\task3107\\2.txt";
        Solution solution = new Solution(pathToFile);
        FileData fileData = solution.getFileData();
        System.out.println(fileData.getClass());
    }

    public FileData getFileData() {
        return fileData;
    }
}
