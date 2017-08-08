package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static FileInputStream fileInputStream;

    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        readFromFileToList(file1, allLines);
        readFromFileToList(file2, forRemoveLines);
        joinData();

    }

    public static void joinData () throws CorruptedDataException {
        boolean ifContains = true;
        for (String listString : forRemoveLines) {
            if (!allLines.contains(listString)) ifContains = false;
        }

    }

    public static void readFromFileToList(String fileName, List<String> list) throws FileNotFoundException, IOException {
        fileInputStream = new FileInputStream(fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            list.add(s);
        }
        fileReader.close();
        fileInputStream.close();
    }
}
