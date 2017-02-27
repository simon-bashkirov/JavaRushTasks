package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;

/*
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("FEBRUARY 1 2020"));
    }

    public static boolean isDateOdd(String date) {
        Date is_date = new Date(date);

        int year = 1900 + is_date.getYear();

        boolean isLeap;
        if (year%4 == 0) {
            if (year%100 == 0 && year%400 != 0) {
                isLeap = false;
            }
            else {
                isLeap = true;
            }
        }
        else {
            isLeap = false;
        }

        int month = 1 + is_date.getMonth();
        int howManyDays = 0;

        for (int i = 1; i < month; i ++) {
            if (i ==  1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) howManyDays += 31;
            else if (i == 4 || i == 6 || i == 9 || i == 11) howManyDays += 30;
            else if (i == 2) {
                if (isLeap) howManyDays += 29;
                else howManyDays += 28;
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(is_date);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        howManyDays += dayOfMonth;

        return !(howManyDays % 2 == 0);

    }


}
