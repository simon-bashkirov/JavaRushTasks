package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private int heigth;
        private int weight;
        private String address;
        private boolean sex;

        public Human(String name) {
            this.name = name;
        }

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(boolean sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public Human(boolean sex, int age, int heigth) {
            this.sex = sex;
            this.age = age;
            this.heigth = heigth;
        }

        public Human(boolean sex, int age, int heigth, int weight) {
            this.sex = sex;
            this.age = age;
            this.heigth = heigth;
            this.weight = weight;
        }

        public Human(String name, String address, boolean sex) {
            this.name = name;
            this.address = address;
            this.sex = sex;
        }

        public Human(String name, int age, int heigth, int weight, String address) {
            this.name = name;
            this.age = age;
            this.heigth = heigth;
            this.weight = weight;
            this.address = address;
        }

        public Human(String name, int age, int heigth, int weight, boolean sex) {
            this.name = name;
            this.age = age;
            this.heigth = heigth;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(String name, int age, int heigth, int weight, String address, boolean sex) {
            this.name = name;
            this.age = age;
            this.heigth = heigth;
            this.weight = weight;
            this.address = address;
            this.sex = sex;
        }

    }
}
