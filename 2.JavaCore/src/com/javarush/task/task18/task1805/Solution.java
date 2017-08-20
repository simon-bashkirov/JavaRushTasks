package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0) list.add(fileInputStream.read());

        fileInputStream.close();
        reader.close();
        sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();


    }

    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int swap = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, swap);
                } else if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }
}
