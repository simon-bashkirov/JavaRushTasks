package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName=reader.readLine();

        FileInputStream inStream = new FileInputStream(sourceFileName);

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (fileReader.ready()) {
            String s = fileReader.readLine();
            int n = Integer.parseInt(s);
            if (n % 2 == 0) numbers.add(n);
        }

        fileReader.close();
        inStream.close();
        reader.close();

        ArrayList<Integer> numbers_sorted = sort(numbers);

        for (int i = 0; i < numbers_sorted.size(); i++) {
            System.out.println(numbers_sorted.get(i));
        }

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list_unsorted)
    {
        int size = list_unsorted.size();
        ArrayList<Integer> list_sorted = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int min = list_unsorted.get(0);
            int min_index = 0;
            for (int j = 0; j < list_unsorted.size(); j++) {
                int n = list_unsorted.get(j);
                if (n < min) {
                    min = n;
                    min_index  = j;
                }
            }
            list_sorted.add(min);
            list_unsorted.remove(min_index);
        }

        return list_sorted;
    }
}
