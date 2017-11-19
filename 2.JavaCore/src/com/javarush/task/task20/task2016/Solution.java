package com.javarush.task.task20.task2016;

import java.io.*;

/*
Минимум изменений
*/
public class Solution {
    public static class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public static class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
/*        String fileName="D:\\dev\\JavaRushTasks\\source_files\\task2016\\1.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        C c = new C("1");
        System.out.println(c.name);

        oos.writeObject(c);
        oos.close();
        fileOutputStream.close();

        Thread.sleep(2000);

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        C c1 = (C)ois.readObject();
        ois.close();
        fileInputStream.close();

        System.out.println(c1.name);*/
    }
}
