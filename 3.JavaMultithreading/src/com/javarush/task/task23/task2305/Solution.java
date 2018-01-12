package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution = new Solution[2];
        /*s[0] = new Solution();
        s[1] = new Solution();
        s[0].innerClasses[0] = s[0].new InnerClass();
        s[0].innerClasses[1] = s[0].new InnerClass();
        s[1].innerClasses[0] = s[0].new InnerClass();
        s[1].innerClasses[1] = s[0].new InnerClass();*/
        for (int i = 0; i < 2; i++) {
            solution[i] = new Solution();
            for (int j = 0; j < 2; j++) solution[i].innerClasses[j] = solution[i].new InnerClass();
        }

        return solution;
    }

    public static void main(String[] args) {

    }
}
