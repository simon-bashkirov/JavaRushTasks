package com.javarush.task.task20.task2028;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("List size is " + list.size());
        System.out.println("Expected parent of 8 is 3, actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("Expected parent of 20 is null, actual parent is " + ((CustomTree) list).getParent("20"));
        BTreePrinter.printNode(((CustomTree) list).getRoot());

        list.remove("3");
        System.out.println("Expected parent of 8 is null, actual parent is " + ((CustomTree) list).getParent("8"));
        BTreePrinter.printNode(((CustomTree) list).getRoot());

        list.add("16");
        System.out.println("Expected parent of 16 is 9, actual parent is " + ((CustomTree) list).getParent("16"));
        BTreePrinter.printNode(((CustomTree) list).getRoot());

        list.remove("4");
        BTreePrinter.printNode(((CustomTree) list).getRoot());
        list.remove("5");
        BTreePrinter.printNode(((CustomTree) list).getRoot());
        list.remove("6");
        BTreePrinter.printNode(((CustomTree) list).getRoot());
        System.out.println("Add 20, Expected true, actual " + list.add("20"));
        BTreePrinter.printNode(((CustomTree) list).getRoot());
        System.out.println("Expected parent of 20 is 1, actual parent is " + ((CustomTree) list).getParent("20"));
    }
}
