package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        Cat tomCat = new Cat("Tom", 4, "grey");
        Cat butchCat = new Cat("Butch", 5, "black");

        Dog spikeDog = new Dog("Spike", "grey", true);
        Dog tykeDog = new Dog("Tyke", "grey", false);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int weight;
        String color;

        public Cat(String name, int weight, String color)
        {
            this.name = name;
            this.weight = weight;
            this.color = color;
        }
    }

    public static class Dog
    {
        String name;
        String color;
        boolean isAngry;

        public Dog(String name, String color, boolean isAngry)
        {
            this.name = name;
            this.color = color;
            this.isAngry = isAngry;
        }
    }

}
