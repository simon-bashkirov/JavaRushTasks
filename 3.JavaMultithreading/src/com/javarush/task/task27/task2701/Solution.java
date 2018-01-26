package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String string = reader.readLine();
//        String substring = reader.readLine();

        String string = "Hello world!";
        String substring = "ello";

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();
//        System.out.println("max = string.length() - substring.length() = " + string.length() + " - " + substring.length() + " = " + max);
        for (int i = 0; i <= max && !found; i++) {
            int length = substring.length();
            int j = i;
            int k = 0;
            found = true;
            while (length-- != 0 && found) {
                if (string.charAt(j++) != substring.charAt(k++)) {
                    found = false;
                }
            }

        }
        return found;
    }
}

