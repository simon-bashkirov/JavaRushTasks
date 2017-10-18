package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int min_ab=getMin2(a,b);
        int max_ab=getMax2(a,b);

        if (c > min_ab && c < max_ab) {
            System.out.println(c);
        }
        else if (c > max_ab) {
            System.out.println(max_ab);
        }
        else if (c < min_ab) {
            System.out.println(min_ab);
        }

    }

    public static int getMin2(int a, int b) {
        if (a < b) {
            return a;
        }
        else {
            return b;
        }
    }

    public static int getMax2(int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }
}
