package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);
        ArrayList<FileInputStream> inFiles = new ArrayList<FileInputStream>();
        inFiles.add(fileInputStream2);
        inFiles.add(fileInputStream3);

        for (FileInputStream fIn : inFiles) {
            if (fIn.available() > 0) {
                byte[] buffer = new byte[fIn.available()];
                int count = fIn.read(buffer);
                fileOutputStream1.write(buffer, 0, count);
            }
            fIn.close();
        }

        fileOutputStream1.close();
        reader.close();
    }
}
