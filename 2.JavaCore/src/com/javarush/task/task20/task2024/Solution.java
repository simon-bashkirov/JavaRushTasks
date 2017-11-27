package com.javarush.task.task20.task2024;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
Java graphs
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution(int node) {
        this.node = node;
    }

    public void add(Solution solution) {
        edges.add(solution);
    }

    public static void main(String[] args) {
        /*Solution s1 = new Solution(1);
        Solution s2 = new Solution(2);
        Solution s3 = new Solution(3);
        Solution s4 = new Solution(4);
        Solution s5 = new Solution(5);
        Solution s6 = new Solution(6);

        s1.add(s2);
        s2.add(s2);
        s2.add(s4);
        s2.add(s5);
        s4.add(s1);
        s4.add(s5);
        s5.add(s4);
        s6.add(s3);*/

    }
}
