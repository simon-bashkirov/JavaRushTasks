package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class Solution {
    public static final byte[] NEWLINE = {13, 10};
    public static String fileName = null;

    public static void main(String[] args) throws Exception {
//        args = new String[4]; args[0] = "-c"; args[1] = "Шорты пляжные синие в красную полоску"; args[2] = "159.00"; args[3] = "12";
//      args = new String[4]; args[0] = "-c"; args[1] = "beach shorts blue"; args[2] = "173.00"; args[3] = "17";
//        args = new String[2]; args[0] = "-d"; args[1] = "19849";
//        args = new String[5]; args[0] = "-u"; args[1] = "19848"; args[2] = "beach shorts purple"; args[3] = "150.00"; args[4] = "2";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
//            fileName = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task1828\\1.txt";
        reader.close();

        if (args[0].equals("-c")) {
            String[] fields = appendSpacesToFields(argsToFields(args));
            createEntry(fields);
        } else if (args[0].equals("-u")) {
            String[] fields = appendSpacesToFields(argsToFields(args));
            updateEntry(fields);
        } else if (args[0].equals("-d")) {
            deleteEntry(args[1]);
        }



    }

    public static void createEntry(String[] fields) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));

        for (String value : fields) {
            fileWriter.write(value);
        }
        fileWriter.newLine();
        fileWriter.close();
    }

    public static void updateEntry(String[] fields) throws IOException {
        String id = fields[0].trim();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName + ".tmp"));

        while (fileReader.ready()) {
            String row = fileReader.readLine();
            String[] splittedRows = row.split(" ");
            String idOfCurrentEntry = splittedRows[0];
            if (!id.equals(idOfCurrentEntry)) {
                fileWriter.write(row);
                fileWriter.newLine();
            } else {
                for (String value : fields) {
                    fileWriter.write(value);
                }
                fileWriter.newLine();
            }
        }

        fileReader.close();
        fileWriter.close();

        removeTmp(fileName);
    }

    public static void deleteEntry(String id) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName + ".tmp"));

        while (fileReader.ready()) {
            String row = fileReader.readLine();
            String[] splittedRows = row.split(" ");
            String idOfCurrentEntry = splittedRows[0];
            if (!id.equals(idOfCurrentEntry)) {
                fileWriter.write(row);
                fileWriter.newLine();
            }
        }

        fileReader.close();
        fileWriter.close();

        removeTmp(fileName);
    }

    public static String[] argsToFields(String[] args) throws IOException {
        String id = "";
        if (args[0].equals("-c")) id = getMaxIdI(fileName).toString();
        else if (args[0].equals("-u")) id = args[1];

        String productName = "";
        int i_base = 0;
        if (args[0].equals("-c")) i_base = 1;
        else if (args[0].equals("-u")) i_base = 2;
        for (int i = i_base; i < args.length - 2; i++) {
            if (i+1 < args.length - 2) productName += args[i] + " ";
            else productName += args[i];
        }

        String price = args[args.length - 2];
        String quantity = args[args.length - 1];

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
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            String row = fileReader.readLine();
            //printRowValues(row);
            int id = Integer.parseInt(row.substring(0,8).trim());
            if (maxId < id) maxId = id;
        }

        fileReader.close();

        return maxId+1;
    }

    //Debug
    public static void printRowValues(String row) {
        String id = row.substring(0,8);
        String productName = row.substring(8,38);
        String price = row.substring(38,46);
        String quantity = row.substring(46,50);
        System.out.println("Printing row values: " + id + productName + price + quantity);
    }

    //Debug
    public static void printArgs(String[] args) {
        System.out.println(Arrays.toString(args));
    }

    public static void copyFile(String src, String dst) throws  IOException {
        FileInputStream fileInputStream = new FileInputStream(src);
        FileOutputStream fileOutputStream = new FileOutputStream(dst);

        while (fileInputStream.available() > 0) {
            byte[] buffer = new byte[1024];
            int count = fileInputStream.read(buffer);
            fileOutputStream.write(buffer,0,count);
        }

        fileOutputStream.close();
        fileInputStream.close();
    }

    public static void removeTmp(String fileName) throws IOException {
        copyFile(fileName + ".tmp", fileName);
        File f = new File(fileName + ".tmp");
        f.delete();
    }
}
