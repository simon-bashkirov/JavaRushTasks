package com.javarush.test.level07.lesson04.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int[] n_arr = new int[10];
        String[] s_arr = new String[10];

        for (int i = 0; i < s_arr.length; i++) {
            s_arr[i] = reader.readLine();
        }

        for (int i = 0; i < s_arr.length; i++) {
            n_arr[i] = s_arr[i].length();
        }

        for (int i = 0; i < n_arr.length; i++) {
            System.out.println(n_arr[i]);
        }

    }
}
