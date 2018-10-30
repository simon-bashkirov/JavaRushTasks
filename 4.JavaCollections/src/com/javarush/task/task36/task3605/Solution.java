package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        List<String> lines = Files.readAllLines(Paths.get(args[0]));

        for (String line : lines) {
            char[] chars = line.toCharArray();
            for (char aChar : chars) {
                if (Character.isLetter(aChar)) {
                    treeSet.add(Character.toLowerCase(aChar));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = treeSet.iterator();
        for (int i = 0; i < 5 && iterator.hasNext(); i++) {
            sb.append(iterator.next());
        }

        System.out.println(sb.toString());
    }
}
