package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Петр");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Сидор");
        map.put("Козлов", "Коля");
        map.put("Иванова", "Аня");
        map.put("Петрова", "Катя");
        map.put("Сидорова", "Катя");
        map.put("Козлова", "Козелина");
        map.put("Вокс", "Алиса");
        map.put("Метелкин", "Дюша");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, Integer> dups = new HashMap<>();
        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (dups.get(value) == null) dups.put(value, 1);
            else dups.put(value, dups.get(value)+1);
        }

        for (HashMap.Entry<String, Integer> entry : dups.entrySet() ) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > 1) removeItemFromMapByValue(map, key);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();

        removeTheFirstNameDuplicates(map);

    }
}
