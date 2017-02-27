package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Collins", new Date("JAN 3 1983"));
        map.put("Perkins", new Date("FEB 5 1997"));
        map.put("Connel", new Date("DEC 22 1990"));
        map.put("Socks", new Date("AUG 15 1987"));
        map.put("Shocks", new Date("JUL 16 1988"));
        map.put("Shmocks", new Date("MAR 25 1993"));
        map.put("Hops", new Date("SEP 20 1982"));
        map.put("Neil", new Date("SEP 29 1982"));
        map.put("Bush", new Date("APR 14 1991"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();
            int month = pair.getValue().getMonth()+1;
            if (month == 6 || month == 7 || month == 8) iterator.remove();;
        }

    }

    public static void main(String[] args) {
    }
}
