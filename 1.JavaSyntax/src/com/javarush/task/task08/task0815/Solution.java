package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов","Александр");
        map.put("Ивановин","Петр");
        map.put("Волков","Петр");
        map.put("Сакс","Петр");
        map.put("Вокса","Алиса");
        map.put("Вок","Петр");
        map.put("Вокс","Иван");
        map.put("Ивановченко","Иван");
        map.put("Цветков","Иван");
        map.put("Белый","Павел");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count=0;
        Iterator<HashMap.Entry<String,String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            if (value.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count=0;
        Iterator<HashMap.Entry<String,String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            System.out.println(key);
            if (key.equals(lastName)) count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
