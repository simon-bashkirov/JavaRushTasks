package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        int side_a = Integer.parseInt(br.readLine());
        int side_b = Integer.parseInt(br.readLine());
        int side_c = Integer.parseInt(br.readLine());

        if ((side_a >= side_b + side_c) || (side_b >= side_a + side_c) || (side_c >= side_a + side_b)) {
            System.out.println("Треугольник не существует.");
        }
        else {
            System.out.println("Треугольник существует.");
        }

    }
}