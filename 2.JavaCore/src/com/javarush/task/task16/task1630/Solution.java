package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    private static String firstFileName;
    private static String secondFileName;
    //static final String solutionPath = "D:\\dev\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task16\\task1630\\";

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        f.join();
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
        private ArrayList<String> rowByRow = new ArrayList<String>();

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            fileContent = "";
            for (String row : rowByRow) {
                fileContent += row;
                fileContent += " ";
            }
            return fileContent;
        }

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fullFileName);
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));

                while (fileReader.ready()) {
                    String s = fileReader.readLine();
                    rowByRow.add(s);
                }

                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}