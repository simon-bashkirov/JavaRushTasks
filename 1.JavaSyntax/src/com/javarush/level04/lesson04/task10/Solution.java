package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if ( a == b ) {
            if ( a == c ) {
                System.out.println(a + " " + b + " " + c);
            }
            else {
                System.out.println(a + " " + b);
            }
        }
        else {
            if (a == c) {
                System.out.println(a + " " + c);
            }
            else if (b == c) {
                System.out.println(b + " " + c);
            }
        }



    }
}