package com.javarush.task.task20.task2008;

import java.io.*;

/* 
Как сериализовать Singleton?
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

/*        FileOutputStream fos1 = new FileOutputStream("myserial1.txt");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        oos1.writeObject(instance);
        FileInputStream fis1 = new FileInputStream("myserial1.txt");
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        Singleton singleton0 = (Singleton) ois1.readObject();*/


        //Serializing the singleton instance
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(instance);
        oos.close();

        //Recreating the instance by reading the serialized object data add
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        //Recreating the instance AGAIN by reading the serialized object data add
        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream ois2 = new ObjectInputStream(byteArrayInputStream);
        Singleton singleton1 = (Singleton) ois2.readObject();
        ois2.close();

        //The singleton behavior has been broken
//        System.out.println(" singleton0 = "+ singleton0.getInstance());
        System.out.println("Instance reference check : " + singleton.getInstance());
        System.out.println("Instance reference check : " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Object reference check : " + singleton);
        System.out.println("Object reference check : " + singleton1);
    }

    public static class Singleton implements Serializable {
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }

        private Object readResolve() {
            return getInstance();
        }
    }
}
