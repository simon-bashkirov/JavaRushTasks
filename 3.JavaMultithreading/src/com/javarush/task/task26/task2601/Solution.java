package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 18, 15, 5, 17};
        System.out.println("Before sort: " + Arrays.toString(array));
//        array = sort(array);
        System.out.println("After sort: " + Arrays.toString(array));
    }

    public static Integer[] sort(Integer[] array) {
        Integer[] arrayCopy = array.clone();
//        Integer[] arraySorted = new Integer[array.length];
        Arrays.sort(arrayCopy);
        final double median;
        if (arrayCopy.length % 2 == 0) {
            median = (arrayCopy[arrayCopy.length/2-1] + arrayCopy[arrayCopy.length/2])/2.0;
        } else {
            median = arrayCopy[arrayCopy.length/2];
        }
        System.out.println(median);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                double d = (median - o2) - (median - o1);
                return (int)Math.round((median - o2) - (median - o1));
            }
        };
        Arrays.sort(arrayCopy, comparator);
        return arrayCopy;
    }
}
