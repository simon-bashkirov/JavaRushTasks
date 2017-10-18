package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        int sum = 0;
        String input = br.readLine();

        while (!input.equals("сумма")) {
            int int_input = Integer.parseInt(input);
            sum=sum+int_input;
            input = br.readLine();
        }

        System.out.println(sum);

    }
}
