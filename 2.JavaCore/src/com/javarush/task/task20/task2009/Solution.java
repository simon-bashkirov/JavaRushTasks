package com.javarush.task.task20.task2009;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/
public class Solution implements Serializable {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws Exception {
/*        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(ClassWithStatic);
        oos.close();*/
    }
}
