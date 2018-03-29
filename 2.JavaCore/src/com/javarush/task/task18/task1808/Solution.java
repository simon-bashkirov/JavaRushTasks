package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        reader.close();

        try (FileInputStream fileInputStream = new FileInputStream(file1);
             FileOutputStream outputStream1 = new FileOutputStream(file2);
             FileOutputStream outputStream2 = new FileOutputStream(file3)) {
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int count = fileInputStream.read(buffer);
                System.out.println(count);
                outputStream1.write(buffer, 0, count/2+count%2);
                outputStream2.write(buffer, count/2+count%2, count/2);

            }
        }

    }
}
