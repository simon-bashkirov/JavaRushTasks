package com.javarush.task.task01.task0140;

import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int a;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println(a*a);
        scanner.close();
    }
}