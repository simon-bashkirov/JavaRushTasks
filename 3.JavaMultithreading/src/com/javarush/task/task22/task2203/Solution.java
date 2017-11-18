package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String[] splittedByTab = string.split("\t");
        //How many tabs = splittedByTab.length-1
        if ((splittedByTab.length-1) < 2) throw new TooShortStringException();
        return splittedByTab[1];
    }

    public static class TooShortStringException extends Exception {
    }
}
