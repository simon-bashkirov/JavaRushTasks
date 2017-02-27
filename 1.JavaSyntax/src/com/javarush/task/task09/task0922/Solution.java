package com.javarush.task.task09.task0922;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy");
        Date date = new Date(s);

        String formattedDate = simpleDateFormat.format(date);
        System.out.println(formattedDate.toUpperCase());
    }
}
