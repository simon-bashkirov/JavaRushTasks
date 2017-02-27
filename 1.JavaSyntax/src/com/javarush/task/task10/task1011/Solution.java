package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        String[] s_to_array = s.split("");
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < s_to_array.length; i++) {
            list.add(s_to_array[i]);
        }

        for (int i = 0; i < s_to_array.length; i++){
            for (int j=0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();

        }

    }

}

