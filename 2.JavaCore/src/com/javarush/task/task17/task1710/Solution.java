package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {

        HashMap<Enum, String> sexes = new HashMap<>();
        sexes.put(Sex.MALE, "м");
        sexes.put(Sex.FEMALE, "ж");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        //df.setTimeZone(TimeZone.getTimeZone("Europe/Athens"));

        //System.out.println("before " + allPeople);
        args = new String[5];
        args[0] = "-c"; args[1] = "Миронов"; args[2] = "м"; args[3] = "15/04/1990";
        //args[0] = "-u"; args[1] = "0"; args[2] = "Миронова"; args[3] = "ж"; args[4] = "15/04/1990";
        //args[0] = "-d"; args[1] = "1";
        //args[0] = "-i"; args[1] = "1";



        if (args[0].equals("-c")) {
            Date bd = df.parse(args[3]);
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], bd));
            } else if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], bd));
            }
            //System.out.println(allPeople);
            System.out.println(allPeople.size()-1);
        } else if (args[0].equals("-u")) {
            Date bd = df.parse(args[4]);
            int index = Integer.parseInt(args[1]);
            String sex = args[3];
            Person aPerson = allPeople.get(index);
            aPerson.setName(args[2]);
            switch (sex) {
                case "м": aPerson.setSex(Sex.MALE); break;
                case "ж": aPerson.setSex(Sex.FEMALE); break;
            }
            aPerson.setBirthDay(df.parse(args[4]));
            allPeople.set(index, aPerson);

        } else if (args[0].equals("-d")) {
            int index = Integer.parseInt(args[1]);
            Person aPerson = allPeople.get(index);
            aPerson.setName(null);
            aPerson.setSex(null);
            aPerson.setBirthDay(null);
            allPeople.set(index, aPerson);
        } else if (args[0].equals("-i")) {
            df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            int index = Integer.parseInt(args[1]);
            Person aPerson = allPeople.get(index);
            System.out.println(aPerson.getName() + " " + sexes.get(aPerson.getSex()) + " " + df.format(aPerson.getBirthDay()));

        }

        System.out.println("after " + allPeople);

    }
}
