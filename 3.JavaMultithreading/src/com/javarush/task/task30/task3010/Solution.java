package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, Integer> baseTenValues = new HashMap<>();

    public static void main(String[] args) {
        args = new String[1];
        args[0] = "12AS08Z/";
        try {
            System.out.println(getMinPossibleRadix(args[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMinPossibleRadix(String number) {
        int minRadix = 2;
        char[] chars = number.toCharArray();
        for (char aChar : chars) {
            if (Character.isLetterOrDigit(aChar)) {
                Integer i = baseTenValues.get(aChar);
//                minRadix = (baseTenValues.get(aChar) + 1) > minRadix ?  (baseTenValues.get(aChar) + 1) : minRadix;
                if (i != null && i + 1 > minRadix) {
                    minRadix = i + 1;
                } else {
                    int a = baseTenValues.put(aChar, Character.getNumericValue(aChar));
                    minRadix = a;
                }
                /*minRadix = ( i != null ) ? i + 1 :
                        (baseTenValues.put(aChar, Character.getNumericValue(aChar)) + 1);*/
            } else {
                return "incorrect";
            }
        }

        return String.valueOf(minRadix);
    }
}