package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        int count = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            if (!s.equals("-1")) {
                try {
                    sum += Integer.parseInt(s);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter numbers only");
                }
            } else {
                if (count > 0) {
                    System.out.println((double)sum/count);
                }
                break;
            }
        }
        bufferedReader.close();
    }
}