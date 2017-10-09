package com.javarush.task.task19.task1917;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task1927\\1.txt.txt";
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(fileName);
        fileConsoleWriter.write(50);
        fileConsoleWriter.write(51);
        fileConsoleWriter.close();
    }
}
