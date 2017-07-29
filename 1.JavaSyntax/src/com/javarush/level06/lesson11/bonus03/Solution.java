package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> a_sorted = new ArrayList<Integer>();
        //int b_l[] = new int[5];
        //int num_of_min[] = new int[5];

        int in_count=5;

        for (int i = 0; i < in_count; i++) {
            a.add(Integer.parseInt(reader.readLine()));
        }



        for (int j = 0; j < in_count; j++) {
            int min = a.get(0);
            int min_n = 0;
            for (int i = 0; i < a.size(); i++) {
                int b = a.get(i);
                if (b < min) {
                    min = b;
                    min_n = i;
                }
            }
            a_sorted.add(min);
            a.remove(min_n);
        }



        for (int i = 0; i < a_sorted.size(); i++) {
            System.out.println(a_sorted.get(i));
        }


    }
}
