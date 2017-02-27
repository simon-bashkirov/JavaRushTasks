package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Вася");
        map.put("Иванов", "Петя");
        map.put("Петров", "Федор");
        map.put("Сидоров", "Егор");
        map.put("Козлова", "Анка");
        map.put("Пиво", "Евгения");
        map.put("Красный", "Петр");
        map.put("Черный", "Катофей");
        map.put("Космос", "Евдотья");
        map.put("Петраскин", "Петр");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
