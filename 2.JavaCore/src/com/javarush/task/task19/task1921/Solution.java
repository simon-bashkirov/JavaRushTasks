package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
//        args = new String[2];
//        args[0] = "D:\\dev\\JavaRushTasks\\source_files\\task1921.txt";
        String fileName = args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        DateFormat df = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);

        while (bufferedReader.ready()) {
            String[] values = bufferedReader.readLine().split(" ");
            String name = "";
            for (int i = 0; i < values.length-3; i++) {
                name += values[i] + " ";
            }
            name = name.trim();
            String day = values[values.length-3];
            String month = values[values.length-2];
            String year = values[values.length-1];
            Date bd = df.parse(appendDayOrMonthWithZero(day) + appendDayOrMonthWithZero(month) + year);
            PEOPLE.add(new Person(name, bd));
        }

        bufferedReader.close();

//        for (Person p : PEOPLE) {
//            System.out.println(p.getName() + " " + p.getBirthday());
//        }
    }

    public static String appendDayOrMonthWithZero(String s) {
        int i = Integer.parseInt(s);
        if (i < 10) s = "0" + s;
        return s;
    }
}
