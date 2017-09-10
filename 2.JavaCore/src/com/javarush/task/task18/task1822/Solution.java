package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[1];
        //args[0] = "3";
        String findId = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));

        while (fileReader.ready()) {
            String row = fileReader.readLine();
            String[] splittedRows = row.split(" ");
            String id = splittedRows[0];
            if (id.equals(findId)) {
                String productName = "";
                for (int i = 1; i < splittedRows.length - 2; i++) {
                    if (i+1 < splittedRows.length - 2) productName += splittedRows[i] + " ";
                    else productName += splittedRows[i];
                }
                String price = splittedRows[splittedRows.length - 2];
                String quantity = splittedRows[splittedRows.length - 1];
                System.out.println(id + " " + productName + " " + price + " " + quantity);
            }
        }

        fileReader.close();
        fileInputStream.close();
    }
}
