package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        String result = number + " =";
        int remainder = 0;
        int pow = 0;
        while (number > 0) {
            remainder = number % 3;
            number /= 3;
            if (remainder == 2) {
                remainder = -1;
                number++;
            }
            result += ( remainder == 0 ? "" : ((remainder == 1) ? " + " : " - ") + (int)Math.pow(3, pow) );
            pow++;
        }
        System.out.println(result);

        /*TODO think of another ways to implement that algorithm
        StringBuilder result = new StringBuilder().append(number).append(" =");
        String [] formats = {""," + %d"," - %d"};
        for (int i = number, tri = 1; 0 < i; i = ++i / 3, tri *= 3) {
            result.append(String.format(formats[i%3],tri));
        }
        return result.toString();
        */
    }
}