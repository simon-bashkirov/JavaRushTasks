package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иванов", 1000);
        map.put("Петров", 300);
        map.put("Сидоров", 180);
        map.put("Козлов", 1200);
        map.put("Васьков", 3000);
        map.put("Николенков",2100);
        map.put("Отважный",700);
        map.put("Хитрый",1600);
        map.put("Хипин", 3400);
        map.put("Андрес", 5000);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<HashMap.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();
            Integer value = pair.getValue();
            if (value < 500) iterator.remove();;
        }
    }

    public static void main(String[] args) {

    }
}