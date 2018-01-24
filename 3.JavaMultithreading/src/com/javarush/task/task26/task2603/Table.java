package com.javarush.task.task26.task2603;

import java.util.ArrayList;

public class Table {
    private ArrayList<Row> rows;

    public Table() {
        rows = new ArrayList<>();
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public void deleteRow(int rowId) {
        rows.remove(rowId);
    }
}
