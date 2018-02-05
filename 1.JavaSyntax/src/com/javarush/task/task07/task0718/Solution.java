package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();

        int firstNotOrdered = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            arrayList.add(reader.readLine());
            if (i > 0) {
                if (arrayList.get(i).length() < arrayList.get(i-1).length()) {
                    firstNotOrdered = i;
                }
            }
        }

        if (firstNotOrdered > 0) System.out.println(firstNotOrdered);
        reader.close();

    }
}

