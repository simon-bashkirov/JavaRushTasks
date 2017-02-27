package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        int length_of_array = array.length;
        ArrayList<String> s_unsorted = new ArrayList<>();
        ArrayList<String> s_sorted = new ArrayList<>();
        for (int i = 0; i < length_of_array; i++) s_unsorted.add(array[i]);
        for (int i = 0; i < length_of_array; i++) {
            String a_z = s_unsorted.get(0);
            int a_z_index = 0;
            for (int j = 0; j < s_unsorted.size(); j++) {
                String s = s_unsorted.get(j);
                if (isGreaterThan(a_z, s)) {
                    a_z = s;
                    a_z_index = j;
                }
            }
            s_sorted.add(a_z);
            s_unsorted.remove(a_z);
        }
        for (int i = 0; i < length_of_array; i++) array[i] = s_sorted.get(i);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
