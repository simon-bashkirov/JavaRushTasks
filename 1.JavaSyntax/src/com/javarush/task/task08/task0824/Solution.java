package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human humanGrandpa1 = new Human("дедушка Ваня", true, 69);
        Human humanGrandpa2 = new Human("дедушка Витя", true, 71);

        Human humanGrandma1 = new Human("бабушка Маша", false, 67);
        Human humanGrandma2 = new Human("бабушка Рая", false, 64);

        Human humanFather = new Human("папа Толик",true, 42);
        Human humanMother = new Human("мама Катя", false, 39);

        Human humanChild1 = new Human("сын Костя", true, 17);
        Human humanChild2 = new Human("сын Леша", true, 17);
        Human humanChild3 = new Human("дочь Ира", true, 14);

        humanFather.children.add(humanChild1);
        humanFather.children.add(humanChild2);
        humanFather.children.add(humanChild3);

        humanMother.children.add(humanChild1);
        humanMother.children.add(humanChild2);
        humanMother.children.add(humanChild3);

        humanGrandpa1.children.add(humanFather);
        humanGrandma1.children.add(humanFather);

        humanGrandpa2.children.add(humanMother);
        humanGrandma2.children.add(humanMother);

        System.out.println(humanGrandpa1);
        System.out.println(humanGrandma1);
        System.out.println(humanGrandpa2);
        System.out.println(humanGrandma2);
        System.out.println(humanFather);
        System.out.println(humanMother);
        System.out.println(humanChild1);
        System.out.println(humanChild2);
        System.out.println(humanChild3);

    }

    public static class Human {

        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
