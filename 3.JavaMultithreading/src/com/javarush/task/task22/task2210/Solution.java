package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] s = getTokens("level22.lesson13.task01", ".");
        System.out.println(Arrays.toString(s));

    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            list.add(stringTokenizer.nextToken());
        }
        return list.toArray(new String[list.size()]);
    }
}
