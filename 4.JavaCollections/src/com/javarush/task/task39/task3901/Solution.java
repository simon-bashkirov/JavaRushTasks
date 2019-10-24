package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Please enter your string: ");
//        String s = bufferedReader.readLine();

        String s = "ttttwt";
        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longestSubstr = 1;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!set.contains(aChar)) {
                set.add(aChar);
            } else {
                if (set.size() > longestSubstr) {
                    longestSubstr = set.size();
                    set = new HashSet<>();
                }
            }
        }
        if (set.size() > longestSubstr) {
            longestSubstr = set.size();
        }
        return longestSubstr;
    }
}
