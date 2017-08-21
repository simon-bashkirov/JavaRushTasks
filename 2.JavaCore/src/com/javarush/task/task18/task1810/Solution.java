package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream;
        ArrayList<FileInputStream> files = new ArrayList<>();

        while (true) {
            String fileName = reader.readLine();
            if (fileName.isEmpty()) break;
            fileInputStream = new FileInputStream(fileName);
            if (fileInputStream.available() < 1000) {
                fileInputStream.close();
                for (FileInputStream f : files) {
                    f.close();
                }
                throw new DownloadException();
            } else {
                files.add(fileInputStream);
            }

        }

    }

    public static class DownloadException extends Exception {

    }
}
