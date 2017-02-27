package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> list = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String s = reader.readLine();
                if (s.isEmpty()) break;
                int i = Integer.parseInt(s);
                list.add(i);
            }
        }
        catch (NumberFormatException e)
        {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        catch (IOException e)
        {

        }
    }
}
