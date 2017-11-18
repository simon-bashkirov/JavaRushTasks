package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static boolean debug = false;
    public static DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        if (debug) System.out.println("before " + allPeople);

//        args = new String[3];
//        args[0] = "-c"; args[1] = "Миронов Мирон"; args[2] = "м"; args[3] = "15/04/1990";
//        args[0] = "-c"; args[1] = "Миронов Мирон"; args[2] = "м"; args[3] = "15/04/1990"; args[4] = "Сидорова Коза"; args[5] = "ж"; args[6] = "20/01/1993";
        //args[0] = "-u"; args[1] = "0"; args[2] = "Миронова"; args[3] = "ж"; args[4] = "15/04/1990";
//        args[0] = "-u"; args[1] = "0"; args[2] = "Миронова Катя"; args[3] = "ж"; args[4] = "15/04/1990"; args[5] = "1"; args[6] = "Сидорова Коза"; args[7] = "ж"; args[8] = "25/03/2000";
//        args[0] = "-d"; args[1] = "1"; args[2] = "0";
//        args[0] = "-i"; args[1] = "1"; args[2] = "0";

        ArrayList<String> personArgs = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            personArgs.add(args[i]);
        }

        switch(args[0]) {
            case("-c"):
                synchronized (allPeople) {
                    createPerson(personArgs);
                    break;
                }
            case("-u"):
                synchronized (allPeople) {
                    updatePerson(personArgs);
                    break;
                }
            case("-d"):
                synchronized (allPeople) {
                    deletePerson(personArgs);
                    break;
                }
            case("-i"):
                synchronized (allPeople) {
                    infoAboutPerson(personArgs);
                    break;
                }
        }

        if (debug) System.out.println("after " + allPeople);
    }

    public static void createPerson(ArrayList<String> personArgs) throws ParseException {
        while (personArgs.size() > 0) {
            try {
                String name = personArgs.remove(0);
                String sex = personArgs.remove(0);
                Date bd = df.parse(personArgs.remove(0));
                if (sex.equals("м")) {
                    allPeople.add(Person.createMale(name, bd));
                } else if (sex.equals("ж")) {
                    allPeople.add(Person.createFemale(name, bd));
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("List of args is not complete");
                e.printStackTrace();
            }
            System.out.println(allPeople.size()-1);
        }
    }

    public static void updatePerson(ArrayList<String> personArgs) throws ParseException {
        while (personArgs.size() > 0) {
            try {
                int index = Integer.parseInt(personArgs.remove(0));
                String name = personArgs.remove(0);
                String sex = personArgs.remove(0);
                Date bd = df.parse(personArgs.remove(0));
                Person aPerson = allPeople.get(index);
                aPerson.setName(name);
                switch (sex) {
                    case "м": aPerson.setSex(Sex.MALE); break;
                    case "ж": aPerson.setSex(Sex.FEMALE); break;
                }
                aPerson.setBirthDay(bd);
                allPeople.set(index, aPerson);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("List of args is not complete");
                e.printStackTrace();
            }
        }
    }

    public static void deletePerson(ArrayList<String> personArgs) {
        while (personArgs.size() > 0) {
            int index = Integer.parseInt(personArgs.remove(0));
            Person aPerson = allPeople.get(index);
            aPerson.setName(null);
            aPerson.setSex(null);
            aPerson.setBirthDay(null);
            allPeople.set(index, aPerson);
        }
    }

    public static void infoAboutPerson(ArrayList<String> personArgs) {
        while (personArgs.size() > 0) {
            int index = Integer.parseInt(personArgs.remove(0));
            df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person aPerson = allPeople.get(index);
            System.out.println(aPerson.getName() + " " + aPerson.getSex().getSexString() + " " + df.format(aPerson.getBirthDay()));
        }
    }
}
