package com.javarush.task.task20.task2028;

import com.javarush.task.task20.task2028.CustomTree.Entry;

public class CustomNodeAdapter implements NodeAdapter {
    Entry entry;

    public CustomNodeAdapter(Entry entry) {
        this.entry = entry;
    }

    public NodeAdapter getLeft() {
        Entry left = entry.getLeftChild();
        return left == null ? null : new CustomNodeAdapter(left);
    }

    public NodeAdapter getRight() {
        Entry right = entry.getRightChild();
        return right == null ? null : new CustomNodeAdapter(right);
    }

    public String getValue() {
        return entry.getElementName();
    }

}
