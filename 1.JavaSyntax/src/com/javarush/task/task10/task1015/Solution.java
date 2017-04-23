package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        //ArrayList<String>[] arrayOfStringList = createList();
        //printList(arrayOfStringList);
    }

    /*public static ArrayList<String>[] createList() {
        ArrayList<String>[] list = new ArrayList<~>[3];
        list[0].add("a");
        list[0].add("b");
        list[1].add("c");
        list[1].add("d");
        list[2].add("e");
        list[2].add("f");
        return list;
    }*/

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}