package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        short b = (short) 45;
        char c = (short) 'c';
        short s = (short) 1005.22;
        int i = 150000;//(short)
        float f = (short) 4.10f;
        double d =  1.256d;//(short)
        double result = (f * b) + (i / c) - (d * s) + 562.78d;
        System.out.println(s);
        System.out.println(i/c);
        System.out.println(d*s);
        System.out.println("result: " + result);
    }
}