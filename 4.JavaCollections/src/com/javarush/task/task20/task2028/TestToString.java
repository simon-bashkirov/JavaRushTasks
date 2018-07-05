package com.javarush.task.task20.task2028;

public class TestToString {

    public static void main(String[] args) {
        System.out.println(getS("11"));
        StringBuilder sb = new StringBuilder();

    }

    public static String getS(String s) {
        return String.format("[%2s]", s);
    }
}
