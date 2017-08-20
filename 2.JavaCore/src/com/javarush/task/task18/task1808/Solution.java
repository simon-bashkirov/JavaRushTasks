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

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(file3);



        if (fileInputStream1.available() > 0) {
            int fileSizeBytes = fileInputStream1.available();
            int toFile1, toFile2;
            if (fileSizeBytes % 2 == 0) {
                toFile1 = toFile2 = fileSizeBytes / 2;
            } else {
                toFile2 = fileSizeBytes / 2;
                toFile1 = toFile2 + 1;
            }
            System.out.println(fileInputStream1.available());
            byte[] buffer = new byte[toFile1];
            int count = fileInputStream1.read(buffer);
            fileOutputStream2.write(buffer, 0, count);
            System.out.println(count);

            buffer = new byte[toFile2];
            count = fileInputStream1.read(buffer);
            fileOutputStream3.write(buffer, 0, count);
            System.out.println(count);


        }
        //System.out.println(countOfCommas);

        fileInputStream1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
        reader.close();

        //System.out.println(min_byte);

    }
}
