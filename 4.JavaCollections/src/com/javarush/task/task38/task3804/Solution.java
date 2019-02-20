package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        Throwable throwable = ExceptionFactory.getException(ApplicationExceptionMessage.SOCKET_IS_CLOSED);
        System.out.println(throwable);
    }
}