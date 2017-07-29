package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> list_of_shortest = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        list_of_shortest.add(0);
        int shortest_length = list.get(0).length()+1;

        for (int i = 0; i < list.size(); i++) {
            int i_length = list.get(i).length();
            if (i_length < shortest_length) {
                shortest_length = i_length;
                list_of_shortest.set(0, i);
                if (list_of_shortest.size() > 1) {
                    int list_of_shortest_size = list_of_shortest.size();
                    for (int j = 1; j < list_of_shortest_size; j++) {
                        list_of_shortest.remove(1);
                    }
                }
            }
            else if (i_length == shortest_length) {
                list_of_shortest.add(i);
            }
        }

        for (int i = 0; i < list_of_shortest.size(); i++) {
            System.out.println(list.get(list_of_shortest.get(i)));
        }
    }
}
