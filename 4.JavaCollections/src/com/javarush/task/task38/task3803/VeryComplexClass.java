package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Double d = Double.class.cast("s");
    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.charAt(0);
    }

    public static void main(String[] args) {

    }
}
