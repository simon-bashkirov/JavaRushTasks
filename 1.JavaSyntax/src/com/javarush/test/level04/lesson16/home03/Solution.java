package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        int sum = 0;

        int a_in = 0;

        while(a_in != -1) {
             a_in = Integer.parseInt(br.readLine());
             sum=sum+a_in;
        }

        System.out.println(sum);


    }
}
