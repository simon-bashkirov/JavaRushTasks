package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        InputStream inputStream = new FileInputStream("1.txt");
    }

    public static void main(String[] args) {

    }
}
