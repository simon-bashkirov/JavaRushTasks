package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);



        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            /*for (byte aBuffer : buffer) {
                System.out.print(aBuffer + " ");
            }*/
            //System.out.println();
            for (int i = 0; i < buffer.length; i++) {
                fileOutputStream.write(buffer[count-1-i]);
                System.out.print(buffer[count-1-i] + " ");
            }
        }

        fileInputStream.close();
        fileOutputStream.close();
        reader.close();

    }
}
