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

    public static void main(String[] args) throws IOException, FileNotFoundException {

        Solution solution = new Solution();

        FileInputStream fileInputStream;
        BufferedReader fileReader;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        fileInputStream = new FileInputStream(file1);
        fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
        while (fileReader.ready()) allLines.add(fileReader.readLine());

        fileInputStream = new FileInputStream(file2);
        fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
        while (fileReader.ready()) forRemoveLines.add(fileReader.readLine());

        fileReader.close();
        fileInputStream.close();

        solution.joinData();

        System.out.println(allLines);
        System.out.println(forRemoveLines);

    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

}
