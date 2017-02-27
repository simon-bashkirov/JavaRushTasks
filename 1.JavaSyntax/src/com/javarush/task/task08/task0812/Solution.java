package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(Integer.parseInt(reader.readLine()));

        int longest_sequence = 1;
        int length_of_sequence = 1;
        //int current_int = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int n = list.get(i);
            int n_prev = list.get(i-1);
            if (n == n_prev) {
                length_of_sequence++;
            }
            else {
                if (length_of_sequence > longest_sequence) longest_sequence = length_of_sequence;
                length_of_sequence = 1;
            }
        }
        if (length_of_sequence > longest_sequence) longest_sequence = length_of_sequence;

        System.out.println(longest_sequence);

    }
}