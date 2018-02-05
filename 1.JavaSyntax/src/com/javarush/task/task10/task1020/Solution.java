package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
//            array[i] = (int)(Math.random()*99);
        }

        sort(array);
        System.out.println(array[9]);
        System.out.println(array[10]);

        reader.close();
    }

    public static void sort(int[] array) {
        Arrays.sort(array);
    }
}
