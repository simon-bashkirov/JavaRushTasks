package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        args = new String[4];
        //args[0] = "19846"; args[1] = "Шорты пляжные синие"; args[2] = "159.00"; args[3] = "12";
        args[0] = "-c"; args[1] = "beach shorts blue"; args[2] = "173.00"; args[3] = "17";
        //int maxId = 0;
        String maxId = "0";

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task1827\\data.txt";

        String[] data = args;
        data[0] = getMaxIdI(fileName).toString();
        appendSpacesToArgs(data);
        printArgs(data);



        for (String s : args) {
            byte[] buffer = s.getBytes();


        }




    }

    public static void appendSpacesToArgs(String[] args) {
        int[] dataSize = {8, 30, 8, 4};
        for (int i = 0; i < dataSize.length; i++) {
            if (args[i].length() < dataSize[i]) {
                for (int j = 0; j < dataSize[i]-args[i].length(); j++) {
                    args[i] += " ";
                }
            }
        }
    }

    @NotNull
    public static Integer getMaxIdI(String fileName) throws IOException {
        int maxId = 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));

        while (fileReader.ready()) {
            String row = fileReader.readLine();
            int id = Integer.parseInt(row.substring(0,8).trim());
            //System.out.println("DEBUG: outside if, row #" + i + ", id is " + id);
            if (maxId < id) {
                maxId = id;
                //System.out.println("DEBUG: inside if, row #" + i + ", maxId is " + maxId);
            }
        }

        fileReader.close();
        fileInputStream.close();

        return maxId+1;
    }

    public static void printArgs(String[] args) {
        System.out.print("[");
        for (String s : args) {
            System.out.print(s + ";");
        }
        System.out.println("]");
    }
}
