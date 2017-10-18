package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> list_of_longest = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        int longest_length = 0;
        list_of_longest.add(0);

        for (int i = 0; i < list.size(); i++) {
            int i_length = list.get(i).length();
            if (i_length > longest_length) {
                longest_length = i_length;
                list_of_longest.set(0, i);
                if (list_of_longest.size() > 1) {
                    int list_of_longest_size = list_of_longest.size();
                    for (int j = 1; j < list_of_longest_size; j++) {
                        list_of_longest.remove(1);
                    }
                }
            }
            else if (i_length == longest_length) {
                list_of_longest.add(i);
            }
        }

        for (int i = 0; i < list_of_longest.size(); i++) {
            System.out.println(list.get(list_of_longest.get(i)));
        }

    }
}
