package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        int d = Integer.parseInt(br.readLine());

        int max_int = getMax4(a, b, c, d);

        System.out.println(max_int);

    }

    public static int getMax2(int a, int b) {

        int max_int;

        if (a > b) max_int = a;
        else max_int = b;

        return max_int;

    }

    public static int getMax4(int a, int b, int c, int d) {

        int ab = getMax2(a,b);
        int cd = getMax2(c,d);

        int max_int = getMax2(ab,cd);

        return max_int;

    }

}
