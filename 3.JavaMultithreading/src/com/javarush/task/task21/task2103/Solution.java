package com.javarush.task.task21.task2103;

import java.util.ArrayList;
import java.util.Arrays;

/*
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (c);
        return !a && !b && c || c;
    }

    public static boolean calculateNew(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) {
        test();
    }

    public static boolean[][] getTestMatrix(int size) {
        boolean[][] matrix = new boolean[(int)Math.pow(2,size)][size];
        for (int i = 0; i < size; i++) {
            int divider = (int)Math.pow(2,i+1);
            int group_of_booleans = matrix.length/divider;
            int xy = 0;
            boolean b = true;
            for (int j = 0; j < divider; j++) {
                int z;
                for (z = 0; z < group_of_booleans; z++) {
                    matrix[xy][i] = b;
//                    if ( i == 2 && xy > 4  ) System.out.println("divider = " + divider + ", j = " + j + ", xy = " + xy + ", i = " + i + ", b = " + b);
                    xy++;
                }
//                System.out.println("i = " + i + ", j = " + j + ", z = " + z + ", before b = " + b);
                b = !b;

/*                if (i == 2) {
                    for (boolean[] aMatrix : matrix) {
                        System.out.println(Arrays.toString(aMatrix));
                    }
                    System.out.println("after b = " + b);
                }*/
            }

        }

/*        for (boolean[] aMatrix : matrix) {
            System.out.println(Arrays.toString(aMatrix));
        }*/
        return matrix;
    }

    public static void test() {
        boolean[][] matrix = getTestMatrix(4);
        for (boolean[] aMatrix : matrix) {
            System.out.print(Arrays.toString(aMatrix) + "  ");
            boolean calculateOriginal = calculate(aMatrix[0],aMatrix[1],aMatrix[2],aMatrix[3]);
            boolean calculateNew = calculateNew(aMatrix[0],aMatrix[1],aMatrix[2],aMatrix[3]);
            System.out.println("calculate: " + calculateOriginal + ", calculateNew: " + calculateNew + ", matches: " + (calculateOriginal == calculateNew ? "yes" : "NO"));
        }
    }
}
