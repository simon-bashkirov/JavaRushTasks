package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] a5 = new int[]{51,52,53,54,55};
        int[] a2 = new int[]{21,22};
        int[] a4 = new int[]{41,42,43,44};
        int[] a7 = new int[]{71,72,73,74,75,76,77};
        int[] a0 = new int[0];
        list.add(a5);
        list.add(a2);
        list.add(a4);
        list.add(a7);
        list.add(a0);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
