package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> filePartNamesList = new ArrayList<>();

        String input;
        while (true) {
            input = reader.readLine();
            if (input.equals("end")) {
                reader.close();
                break;
            }
            else if (!input.isEmpty()) {
                filePartNamesList.add(input);
            }
        }

        Collections.sort(filePartNamesList);
        //System.out.println(input);
        String fullFileName = filePartNamesList.get(0).substring(0,filePartNamesList.get(0).length()-6);
        FileOutputStream fileOutputStream = new FileOutputStream(fullFileName);

        for (String filePartName : filePartNamesList) {
            FileInputStream fileInputStream = new FileInputStream(filePartName);
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int count = fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
            }
            fileInputStream.close();
        }

        fileOutputStream.close();
    }
}
