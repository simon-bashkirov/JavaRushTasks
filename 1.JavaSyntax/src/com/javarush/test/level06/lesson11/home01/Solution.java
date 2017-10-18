package com.javarush.test.level06.lesson11.home01;

/* Класс Cat и статическая переменная catCount
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная
catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Cat Cat1 = new Cat();
        Cat Cat2 = new Cat();
        Cat Cat3 = new Cat();
        Cat Cat4 = new Cat();
        Cat Cat5 = new Cat();
        Cat Cat6 = new Cat();
        Cat Cat7 = new Cat();
        Cat Cat8 = new Cat();
        Cat Cat9 = new Cat();
        Cat Cat10 = new Cat();

        System.out.print(Cat1.catCount);
    }

    public static class Cat
    {
        public static int catCount;

        public Cat() {
            catCount++;
        }
    }

}
