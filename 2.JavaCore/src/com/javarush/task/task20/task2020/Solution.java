package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task2020\\1.txt";
        Person person = new Person("Ivan","Ivanchuk","Ukraine",Sex.MALE);

        FileOutputStream fileOutput = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutput);

        oos.writeObject(person);

        oos.close();
        fileOutput.close();

        FileInputStream fiStream = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fiStream);

        Person loadedPerson = (Person)ois.readObject();

        if (person.equals(loadedPerson)) System.out.println("Person was loaded correctly");
        else {
            System.out.println("NOT loaded correctly");
            System.out.println(person);
            System.out.println(loadedPerson);
        }

        ois.close();
        fiStream.close();
    }

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
            if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
            if (fullName != null ? !fullName.equals(person.fullName) : person.fullName != null) return false;
            if (greetingString != null ? !greetingString.equals(person.greetingString) : person.greetingString != null)
                return false;
            if (country != null ? !country.equals(person.country) : person.country != null) return false;
            return sex == person.sex;
        }

        @Override
        public int hashCode() {
            int result = firstName != null ? firstName.hashCode() : 0;
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
            result = 31 * result + (greetingString != null ? greetingString.hashCode() : 0);
            result = 31 * result + (country != null ? country.hashCode() : 0);
            result = 31 * result + (sex != null ? sex.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", greetingString='" + greetingString + '\'' +
                    ", country='" + country + '\'' +
                    ", sex=" + sex +
                    '}';
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

}
