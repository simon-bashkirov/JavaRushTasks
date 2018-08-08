package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(method1()));
    }

    public static StackTraceElement[] method1() {
        System.out.println(Arrays.toString(method2()));
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements;
    }

    public static StackTraceElement[] method2() {
        System.out.println(Arrays.toString(method3()));
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements;
    }

    public static StackTraceElement[] method3() {
        System.out.println(Arrays.toString(method4()));
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements;
    }

    public static StackTraceElement[] method4() {
        System.out.println(Arrays.toString(method5()));
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements;
    }

    public static StackTraceElement[] method5() {
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements;
    }
}
