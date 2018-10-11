package com.javarush.task.task20.task2028;

import com.javarush.task.task20.task2028.CustomTree.Entry;

public class NodeAdapter {
    Entry entry;

    public NodeAdapter(Entry entry) {
        this.entry = entry;
    }

    public NodeAdapter getLeft() {
        Entry left = entry.getLeftChild();
        return left == null ? null : new NodeAdapter(left);
    }

    public NodeAdapter getRight() {
        Entry right = entry.getRightChild();
        return right == null ? null : new NodeAdapter(right);
    }

    public Integer getValue() {
        return Integer.parseInt(entry.getElementName());
    }
}
