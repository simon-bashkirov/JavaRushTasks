package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int[] n_arr = new int[10];

        for (int i = 0; i < n_arr.length; i++) {
            n_arr[i] = Integer.parseInt(reader.readLine());
        }

        n_arr = reverseArr(n_arr);

        for (int i = 0; i < n_arr.length; i++) {
            System.out.println(n_arr[i]);
        }

    }

    public static int[] reverseArr(int[] array) {
        int[] reverseArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverseArray[i] = array[array.length-i-1];
        }
        return reverseArray;
    }
}
