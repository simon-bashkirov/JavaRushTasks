package com.javarush.task.task20.task2018;

import java.io.*;

/*
Найти ошибки
*/
public class Solution implements Serializable {
    public static class A{
        protected String name = "A";

        public A() {
            this.name += "+A()";
        }
        public A(String name) {
            this.name += name;
        }

    }

    public class B extends A implements Serializable{

        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
//            System.out.println("B - writing");
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//            System.out.println("B - reading");
            in.defaultReadObject();
            name=(String)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2");
        System.out.println(b.name);
//        System.out.println("b.name\t= " + b.name);

        oos.writeObject(b);
//        System.out.println(arrayOutputStream.toString());

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
//        byte[] buffer = new byte[arrayInputStream.available()];
//        System.out.println(arrayInputStream.read(buffer));
//        System.out.println(buffer);
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);



        B b1 = (B)ois.readObject();
        System.out.println(b1.name);

//        System.out.println("b1.name\t= " + b1.name);
    }
}
