package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = reader.readLine();
            if (s.equals("exit")) break;
            else if (s.contains(".")) {
                Double d = Double.parseDouble(s);
                print(Double.parseDouble(s));
            }
            else if (s.matches("^-?[0-9]{1,10}$")) {
                int n = Integer.parseInt(s);
                if ( n > 0 && n < 128 ) {
                    print((short)n);
                } else if ( n < 0 || n >= 128) {
                    print((Integer)n);
                } else if ( n == 0 ) {
                    print(String.valueOf(n));
                }
            }
            else print(s);
        }

        reader.close();

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
