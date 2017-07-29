package com.javarush.test.level03.lesson08.task01;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        //System.out.println("Enter the name:");
        String years=br.readLine();
        //System.out.println("How many years left:");
        String name=br.readLine();
        System.out.println(name + " захватит мир через " + years + " лет. Му-ха-ха!");

        br.close();
        r.close();

    }
}