package com.javarush.test.level04.lesson04.task09;

/* Светофор
Работа светофора для пешеходов запрограммирована следующим образом: в начале каждого часа в течение трех минут горит зеленый сигнал,
затем в течение одной минуты — желтый, а потом в течение одной минуты — красный, затем опять зеленый горит три минуты и т. д.
Ввести с клавиатуры вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
Определить, сигнал какого цвета горит для пешеходов в этот момент.
Результат вывести на экран в следующем виде:
"зеленый" - если горит зеленый цвет, "желтый" - если горит желтый цвет, "красный" - если горит красный цвет.
Пример для числа 2.5:
зеленый
Пример для числа 3:
желтый
Пример для числа 4:
красный
Пример для числа 5:
зеленый
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        double minute = Double.parseDouble(br.readLine());
        int m_int = (int)minute;

        //System.out.println("res " + m_int%5);

        if (minute >=0 || minute <= 59) {
            if ((m_int>=0 && m_int<=2) || (m_int%5>=0 && m_int%5<=2)) {
                System.out.println("зеленый");
            }
            else if ((m_int==3) || (m_int%5==3)) {
                System.out.println("желтый");
            }
            else if ((m_int==4) || (m_int%5==4)) {
                System.out.println("красный");
            }
        }

    }
}