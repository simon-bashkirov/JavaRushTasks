package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        short b = (short) 45;
        //System.out.println("b = " + b);
        char c = (short) 'c';
        //System.out.println("c = " + c);
        short s = (short) 1005.22;
        //System.out.println("s = " + s);
        int i = (int) 150000;
        //System.out.println("i = " + i);
        float f = (float) 4.10f;
        //System.out.println("f = " + f);
        double d = (double) 1.256d;
        //System.out.println("d = " + d);
        //System.out.println("(f * b) + (i / c) - (d * s) + 562.78d");
        //System.out.println("(" + f  + "* " + b + ") + (" + i + " / " + c + ") - (" + d + " * " + s + ") + 562.78d");
        //System.out.println("(" + f*b + ") + (" + i/c + ") - (" + d*s + ") + 562.78d");
        double result = (f * b) + (i / c) - (d * s) + 562.78d;
        System.out.println("result: " + result);
    }
}