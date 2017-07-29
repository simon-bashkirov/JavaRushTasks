package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int big_arr[] = new int[20];
        int b = big_arr.length;
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < big_arr.length; i++) {
            big_arr[i] = Integer.parseInt(reader.readLine());
        }

        int small_arr1[] = new int[10];
        int small_arr2[] = new int[10];
        int s = small_arr2.length;

        for (int i = 0; i < small_arr1.length; i++) {
            small_arr1[i] = big_arr[i];
            small_arr2[s-i-1] = big_arr[b-i-1];
        }

        for (int i = 0; i < small_arr2.length; i++) {
            System.out.println(small_arr2[i]);
        }

    }
}
