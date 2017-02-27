package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            int n = array.get(i);
            if (n < min) min = n;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        List<Integer> integerList = new ArrayList<>();
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int array_size = Integer.parseInt(reader.readLine());
        for (int i = 0; i < array_size; i++) {
            integerList.add(Integer.parseInt(reader.readLine()));
        }
        return integerList;
    }
}
