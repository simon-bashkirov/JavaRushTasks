package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileInputStream inputStream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));

            String s;

            while (fileReader.ready()) {
                s = fileReader.readLine();
                lines.add(s);
            }

            fileReader.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
