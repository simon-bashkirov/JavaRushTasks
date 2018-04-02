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
//        String fileName = bufferedReader.readLine();
        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task2209\\1.txt";
        bufferedReader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
        String s = bufferedFileReader.readLine();
        String[] s_splitted = s.split(" ");
//        s_splitted = new String[4];
        bufferedFileReader.close();

        StringBuilder result = getLine(s_splitted);
        System.out.println("Initial string: [" + s + "]");
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder();
        if (list.size() > 0) {
            result.append(list.remove(0));
            outer:
            while(list.size() > 0) {
//                System.out.println(result.toString());
                char resultLastLetter = Character.toLowerCase(result.charAt(result.length()-1));
                for (int i =0; i < list.size(); i++) {
                    String word = list.get(i);
                    char wordFirstLetter = Character.toLowerCase(word.charAt(0));
                    if (resultLastLetter==wordFirstLetter) {
                        result.append(" ").append(word);
                        list.remove(i);
                        continue outer;
                    } else {
                        char resultFirstLetter = Character.toLowerCase(result.charAt(0));
                        char wordLastLetter = Character.toLowerCase(word.charAt(word.length()-1));
                        if (resultFirstLetter==wordLastLetter) {
                            result.insert(0, word + " ");
                            list.remove(i);
                            continue outer;
                        }
                    }
                }
                break;
            }
        }
        return result;
    }

    public static void printPairs(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            List<String> pairs = new ArrayList<>();
            String word = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i!=j) {

                }

            }
        }
    }

    public static void where() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( Thread.currentThread().getStackTrace()[1].getLineNumber());
    }

    public enum Position {
        BEFORE,
        AFTER;
    }
}
