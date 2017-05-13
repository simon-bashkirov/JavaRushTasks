package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(byte m, byte n, int value) {
        System.out.println("Заполняем объектами int");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(short m, short n, short value) {
        System.out.println("Заполняем объектами short");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(double m, double n, double value) {
        System.out.println("Заполняем объектами double");
        printMatrix((int)m, (int)n, (Object) value);
    }

    public static void printMatrix(int m, int n, long value) {
        System.out.println("Заполняем объектами long");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, float value) {
        System.out.println("Заполняем объектами float");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, byte value) {
        System.out.println("Заполняем объектами byte");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Character value) {
        System.out.println("Заполняем объектами Character");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, HashMap value) {
        System.out.println("Заполняем объектами HashMap");
        printMatrix(m, n, (Object) value);
    }
}
