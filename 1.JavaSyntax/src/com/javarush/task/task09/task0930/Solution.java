package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> list_of_string_indexes = new ArrayList<>();
        ArrayList<Integer> list_of_string_indexes_sorted = new ArrayList<>();
        ArrayList<Integer> list_of_number_indexes = new ArrayList<>();
        ArrayList<Integer> list_of_number_indexes_sorted = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) list_of_number_indexes.add(i);
            else list_of_string_indexes.add(i);
        }
        ArrayList<Integer> list_of_string_indexes_copy = new ArrayList<>(list_of_string_indexes);
        ArrayList<Integer> list_of_number_indexes_copy = new ArrayList<>(list_of_number_indexes);
        int length_list_of_string_indexes = list_of_string_indexes.size();
        int length_list_of_number_indexes = list_of_number_indexes.size();

        for (int i = 0; i < length_list_of_string_indexes; i++) {
            String a_z = array[list_of_string_indexes.get(0)];
            int a_z_index_of_index = 0;
            for (int j = 0; j < list_of_string_indexes.size(); j++) {
                String s = array[list_of_string_indexes.get(j)];
                if (isGreaterThan(a_z, s)) {
                    a_z = s;
                    a_z_index_of_index = j;
                }
            }
            list_of_string_indexes_sorted.add(list_of_string_indexes.get(a_z_index_of_index));
            list_of_string_indexes.remove(a_z_index_of_index);
        }

        for (int i = 0; i < length_list_of_number_indexes; i++) {
            int nine_to_zero = Integer.parseInt(array[list_of_number_indexes.get(0)]);
            int nine_to_zero_index_of_index = 0;
            for (int j = 0; j < list_of_number_indexes.size(); j++) {
                int n = Integer.parseInt(array[list_of_number_indexes.get(j)]);
                if (n > nine_to_zero) {
                    nine_to_zero = n;
                    nine_to_zero_index_of_index = j;
                }
            }
            list_of_number_indexes_sorted.add(list_of_number_indexes.get(nine_to_zero_index_of_index));
            list_of_number_indexes.remove(nine_to_zero_index_of_index);
        }

        String[] array_copy = array.clone();

        for (int i = 0; i < list_of_string_indexes_sorted.size(); i++) {
            int unsorted_index = list_of_string_indexes_copy.get(i);
            int sorted_index = list_of_string_indexes_sorted.get(i);
            array[unsorted_index] = array_copy[sorted_index];
        }

        for (int i = 0; i < list_of_number_indexes_sorted.size(); i++) {
            int unsorted_index = list_of_number_indexes_copy.get(i);
            int sorted_index = list_of_number_indexes_sorted.get(i);
            array[unsorted_index] = array_copy[sorted_index];
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
