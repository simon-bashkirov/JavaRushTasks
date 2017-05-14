package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        String obj_alert = null;
        String[] url_splitted_by_separator = url.split("[?]|&");
        for (int i = 1; i < url_splitted_by_separator.length; i++) {
            String separated_item = url_splitted_by_separator[i];
            if (separated_item.contains("=")) {
                String[] keys = separated_item.split("=");
                if (keys[0].equals("obj")) obj_alert = keys[1];
                System.out.print(keys[0] + " ");
            } else {
                System.out.print(separated_item + " ");
            }
        }
        System.out.println();

        if (obj_alert != null) {
            try {
                Double d = Double.parseDouble(obj_alert);
                alert(d);
            } catch (NumberFormatException e) {
                alert(obj_alert);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
