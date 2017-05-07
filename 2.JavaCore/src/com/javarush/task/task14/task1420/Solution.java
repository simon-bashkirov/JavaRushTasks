package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        if ( a <= 0 || b <= 0 ) {
            throw new Exception();
        }

        int gcd = gCD(a,b);

        System.out.println(gcd);
    }

    public static int gCD (int a, int b) {

        int gcd;

        if (a == b) gcd=a;
        else if (a == 0) gcd=b;
        else if (b == 0) gcd=a;
        else {
            int d = 0;
            while (a % 2 == 0 & b % 2 == 0) {
                a = a / 2;
                b = b / 2;
                d++;
            }

            while (a != b) {
                if (a % 2 == 0) a = a / 2;
                else if (b % 2 == 0) b = b / 2;
                else if (a > b) a = (a - b) / 2;
                else b = (b - a) / 2;
            }

            gcd = (int)Math.pow(2, d) * a;
        }

        return gcd;
    }
}
