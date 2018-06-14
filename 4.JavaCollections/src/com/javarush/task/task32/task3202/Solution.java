package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:\\dev\\JavaRushTasks\\source_files\\task3202\\1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();

        if (is == null)
            return sw;

        try (InputStreamReader inputStreamReader = new InputStreamReader(is)) {
            char[] buffer = new char[8*1024];
            while (inputStreamReader.ready()) {
                int len = inputStreamReader.read(buffer);
                sw.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return sw;
        }

        return sw;
    }
}