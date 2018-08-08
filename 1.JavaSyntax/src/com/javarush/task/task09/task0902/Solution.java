package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
0 - getStackTrace
1 - current method itself
2 - method which called current method
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(method1());
    }

    public static String method1() {
        System.out.println(method2());
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method2() {
        System.out.println(method3());
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method3() {
        System.out.println(method4());
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method4() {
        System.out.println(method5());
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method5() {
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }
}
