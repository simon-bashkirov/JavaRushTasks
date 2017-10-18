package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        //System.out.println("Enter the name:");
        String name=br.readLine();
        //System.out.println("How many years left:");
        String number1=br.readLine();
        String number2=br.readLine();
        System.out.println(name + " получает " + number1 + " через " + number2 + " лет.");

        br.close();
        r.close();

    }
}