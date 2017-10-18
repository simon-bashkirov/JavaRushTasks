package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human humanGrandpa1 = new Human("Ваня", true, 69, null, null);
        Human humanGrandpa2 = new Human("Витя", true, 71, null, null);

        Human humanGrandma1 = new Human("Маша", false, 67, null, null);
        Human humanGrandma2 = new Human("Рая", false, 64, null, null);

        Human humanFather = new Human("Толик",true, 42, humanGrandpa1, humanGrandma1);
        Human humanMother = new Human("Катя", false, 39, humanGrandpa2, humanGrandma2);

        Human humanChild1 = new Human("Костя", true, 17, humanFather, humanMother);
        Human humanChild2 = new Human("Леша", true, 17, humanFather, humanMother);
        Human humanChild3 = new Human("Ира", true, 14, humanFather, humanMother);

        System.out.println(humanGrandpa1);
        System.out.println(humanGrandpa2);

        System.out.println(humanGrandma1);
        System.out.println(humanGrandma2);

        System.out.println(humanFather);
        System.out.println(humanMother);

        System.out.println(humanChild1);
        System.out.println(humanChild2);
        System.out.println(humanChild3);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
