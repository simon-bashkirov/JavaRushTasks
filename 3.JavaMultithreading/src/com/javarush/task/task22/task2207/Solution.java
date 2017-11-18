package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        ArrayList<String> unique_words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
//        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task2207\\1.txt";
        bufferedReader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));

        while (bufferedFileReader.ready()) {
            String s = bufferedFileReader.readLine();
            String[] stringOfWords = s.split(" ");
            for (String w : stringOfWords) {
                String w_reversed = new StringBuilder(w).reverse().toString();
                if (unique_words.contains(w)) {
                    Pair p = new Pair(w,w);
                    if (!result.contains(p)) result.add(p);
                } else if (unique_words.contains(w_reversed)) {
                    unique_words.add(w);
                    result.add(new Pair(w_reversed,w));
                } else unique_words.add(w);
            }
        }

        bufferedFileReader.close();

        for (Pair p : result) {
            System.out.println(p);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
