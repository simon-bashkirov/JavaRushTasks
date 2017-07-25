package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String fileContent;

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
            fileContent = "";
        }

        @Override
        public String getFileContent() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fullFileName);
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));

                while (fileReader.ready()) {
                    String s = fileReader.readLine();
                    fileContent += (s + " ");
                }

                fileReader.close();
            } catch (IOException e) {
                System.err.println(e);
            }
            return fileContent;
        }

        @Override
        public void run() {
            getFileContent();
        }
    }
}
