package com.javarush.task.task20.task2006;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\dev\\JavaRushTasks\\source_files\\task2006\\1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
        objectOutputStream.writeObject(ivanov);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\dev\\JavaRushTasks\\source_files\\task2006\\1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        Human somePerson = (Human)object;
        System.out.println("ivanov: " + ivanov);
        System.out.println("somePerson: " + somePerson);
        if (ivanov.equals(somePerson)) System.out.println("class was loaded correctly");
        else System.out.println("class was NOT loaded correctly");
    }

    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public String toString() {
            String toString = "Human's name:" + this.name;
            for (Asset a : assets) {
                toString += ". Asset name: " + a.getName() + ", asset price: " + a.getPrice();
            }
            return toString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result; /*return (int) (Math.random() * 100);*/
        }
    }

}
