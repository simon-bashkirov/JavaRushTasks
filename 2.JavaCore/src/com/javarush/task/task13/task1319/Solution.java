package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName=reader.readLine();

        FileOutputStream outStream = new FileOutputStream (sourceFileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String s = reader.readLine();
            list.add(s);
            if (s.equals("exit")) break;
        }

        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
            writer.newLine();
        }

        writer.close();
        reader.close();

    }
}
