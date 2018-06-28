package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
//    Entry<String> currentEntry;

    public static void main(String[] args) {
        List<String> list = new CustomTree("0");
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public CustomTree(String s) {
        root = new Entry<>(s);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(String s) {
        Entry<String> currentEntry = root;
        while (true) {
            if (currentEntry.isAvailableToAddChildren()) {

            }
        }
    }

    public boolean dd() {
        Entry<String> currentEntry = null;
        Entry<String> entry = new Entry<>("");
        if (!currentEntry.isAvailableToAddChildren()) {
            if (currentEntry.getLeftChild().isAvailableToAddChildren())
                currentEntry = currentEntry.getLeftChild();
            else if (currentEntry.getRightChild().isAvailableToAddChildren())
                currentEntry = currentEntry.getRightChild();
            else
                throw new RuntimeException(new CustomTreeStructureException());
        }
        entry.setParent(currentEntry);
        entry.setLineNumber(currentEntry.getLineNumber()+1);
        currentEntry.addChild(entry);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    public String getParent(String s) {
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            availableToAddLeftChildren = (leftChild == null);
            availableToAddRightChildren = (rightChild == null);
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        boolean addChild(Entry<T> entry) {
            if (availableToAddLeftChildren)
                leftChild = entry;
            else if (availableToAddRightChildren)
                rightChild = entry;
            else return false;
            return true;
        }

        int getLineNumber() {
            return lineNumber;
        }

        void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        Entry<T> getParent() {
            return parent;
        }

        void setParent(Entry<T> parent) {
            this.parent = parent;
        }

        Entry<T> getLeftChild() {
            return leftChild;
        }

        Entry<T> getRightChild() {
            return rightChild;
        }

        int getCountOfChildren() {
            return 0;
        }

    }

    static class CustomTreeStructureException extends Exception {

    }
}
