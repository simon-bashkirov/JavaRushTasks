package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
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
