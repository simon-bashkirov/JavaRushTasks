package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
        Comparator<Row> compareById = new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getId() - o2.getId();
            }
        };
        Comparator<Row> compareByName = new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<Row> compareByPrice = new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return (int)Math.round(o1.getPrice() - o2.getPrice());
            }
        };

        ArrayList<Row> rows = new ArrayList<Row>() {
            @Override
            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                for (Row row : this) {
                    stringBuilder.append(row + "\r\n");
                }
                return stringBuilder.toString();
            }
        };
        rows.add(new Row(1,"Shorts", 20.0));
        rows.add(new Row(2,"Jacket", 50.0));
        rows.add(new Row(3,"Shorts", 17.5));
        rows.add(new Row(4,"Socks", 5.5));
        rows.add(new Row(5,"Shoes", 75.0));
        CustomizedComparator customizedComparator = new CustomizedComparator(compareByName, compareByPrice);
        System.out.println("Before sort:");
        System.out.println(rows);
        Collections.sort(rows, customizedComparator);
        System.out.println("After sort:");
        System.out.println(rows);

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int compare = 0;
            for (Comparator comparator : comparators) {
                compare = comparator.compare(o1,o2);
                if (compare != 0) {
                    break;
                }
            }
            return compare;
        }
    }
}
