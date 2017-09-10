package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;

public class Solution {
    public static final byte[] NEWLINE = {13, 10};
    public static String fileName = null;

    public static void main(String[] args) throws Exception {
//        args = new String[4];
//        args[0] = "-c"; args[1] = "Шорты пляжные синие в красную полоску"; args[2] = "159.00"; args[3] = "12";
        //args[0] = "-c"; args[1] = "beach shorts blue"; args[2] = "173.00"; args[3] = "17";

        if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
//            fileName = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task1827\\data.txt";
            String[] fields = appendSpacesToFields(argsToFields(args));
            addEntry(fields);
            //printArgs(fields);
        }

    }

    public static void addEntry(String[] args) throws IOException {
        //appendSpacesToArgs(args);
        //printArgs(data);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);


        fileOutputStream.write(NEWLINE);
        for (String value : args) {
            byte[] buffer = value.getBytes();
            fileOutputStream.write(buffer);
        }

        fileOutputStream.close();
    }
    
    public static String[] argsToFields(String[] args) throws IOException {
        String productName = "";
        String id = getMaxIdI(fileName).toString();
        for (int i = 1; i < args.length - 2; i++) {
            if (i+1 < args.length - 2) productName += args[i] + " ";
            else productName += args[i];
        }
        String price = args[args.length - 2];
        String quantity = args[args.length - 1];
        //System.out.println(id + " " + productName + " " + price + " " + quantity);
        return new String[]{id, productName, price, quantity};
    }

    public static String[] appendSpacesToFields(String[] args) {
        int[] maxFieldSize = {8, 30, 8, 4};
        for (int i = 0; i < maxFieldSize.length; i++) {
            if (args[i].length() < maxFieldSize[i]) {
                //System.out.println("DEBUG: appending element #" + i + " with " + (maxFieldSize[i]-args[i].length()) + " spaces");
                int howManySpacesToAppend = maxFieldSize[i]-args[i].length();
                for (int j = 0; j < howManySpacesToAppend; j++) {
                    args[i] += " ";
                    //System.out.println("DEBUG: appending element #" + i + " with a space, j = " + j + ", boolean: " + (j < maxFieldSize[i]-args[i].length()));
                }
            } else if (args[i].length() > maxFieldSize[i]) {
                args[i] = args[i].substring(0,maxFieldSize[i]);
            }
        }
        return args;
    }

    public static Integer getMaxIdI(String fileName) throws IOException {
        int maxId = 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));

        while (fileReader.ready()) {
            String row = fileReader.readLine();
            //printRowValues(row);
            int id = Integer.parseInt(row.substring(0,8).trim());
            if (maxId < id) maxId = id;
        }

        fileReader.close();
        fileInputStream.close();

        return maxId+1;
    }

    public static void printRowValues(String row) {
        String id = row.substring(0,8);
        String productName = row.substring(8,38);
        String price = row.substring(38,46);
        String quantity = row.substring(46,50);
        System.out.println("Printing row values: " + id + productName + price + quantity);
    }

    public static void printArgs(String[] args) {
        System.out.print("[");
        int i = 0;
        for (String s : args) {
            i++;
            System.out.print(s);
            if (i != args.length) System.out.print(", ");
        }
        System.out.println("]");
    }
}
