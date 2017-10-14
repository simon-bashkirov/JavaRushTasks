package com.javarush.task.task20.task2013;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            children = new ArrayList<Person>();
        }

        public Person() {}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        public void addChildren(Person person) {
            children.add(person);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) {
/*        Person grandFather = new Person("John", "Grandfather", 64);
        Person grandMother = new Person("Anna", "Grandmother", 55);
        Person father = new Person("Phil", "Father", 36);
        Person mother = new Person("Jennie", "Mother", 27);
        Person son = new Person("Jack", "Son", 9);
        Person daughter = new Person("Vesta", "Daughter", 7);

        son.setFather(father);
        son.setMother(mother);
        daughter.setFather(father);
        daughter.setMother(mother);
        father.setFather(grandFather);
        mother.setMother(grandMother);*/


    }
}
