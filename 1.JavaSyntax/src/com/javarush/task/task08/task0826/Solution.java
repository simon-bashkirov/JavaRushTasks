package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        int size = array.length;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list_sorted = new ArrayList<>();
        for (int i = 0; i < size; i++) list.add(array[i]);

        for (int i = 0; i < size; i++) {
            int max = list.get(0);
            int max_index = 0;
            for (int j = 0; j < list.size(); j++) {
                int a = list.get(j);
                if (a > max) {
                    max = a;
                    max_index  = j;
                }
            }
            list_sorted.add(max);
            list.remove(max_index);
        }

        for (int i = 0; i < list_sorted.size(); i++) {
            array[i] = list_sorted.get(i);
        }
    }
}
