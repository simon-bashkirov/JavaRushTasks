package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileInputStream> files = new ArrayList<>();

        while (true) {
            String input = reader.readLine();
            if (!input.isEmpty()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(input);
                    files.add(fileInputStream);
                } catch (FileNotFoundException e) {
                    System.out.println(input);
                    for (FileInputStream f : files) {
                        f.close();
                    }
                    reader.close();
                    return;
                }
            }
        }

    }
}
