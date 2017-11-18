package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getQuery(params));

    }
    public static String getQuery(Map<String, String> params) {
        String result = "";
        for (HashMap.Entry<String, String> entry : params.entrySet()) {
            if (!(entry.getValue() == null)) {
                result += (result.equals("") ? "" : " and ") + entry.getKey() + " = '" + entry.getValue() + "'";
            }
        }
        return result;
    }
}
