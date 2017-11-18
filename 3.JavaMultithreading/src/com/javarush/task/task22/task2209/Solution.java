package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
//        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task2209\\1.txt";
        bufferedReader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
        String s = bufferedFileReader.readLine();
        String[] s_splitted = s.split(" ");
//        s_splitted = new String[4];
        bufferedFileReader.close();

        StringBuilder result = getLine(s_splitted);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder();
        if (list.size() > 0) {
            result.append(list.remove(0));
            while(list.size() > 0) {
//            where();
                char lastLetter = result.charAt(result.length()-1);
//            System.out.println(result.toString());
//            System.out.println(lastLetter);
                for (int i =0; i < list.size(); i++) {
//                where();
                    String w = list.get(i);
                    char firstLetter = Character.toLowerCase(w.charAt(0));
//                System.out.println(w);
//                System.out.println(firstLetter);
                    if (lastLetter==firstLetter) {
//                    System.out.println("lastLetter==firstLetter");
                        result.append(" ").append(w);
                        list.remove(i);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void where() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( Thread.currentThread().getStackTrace()[1].getLineNumber());
    }
}
