package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    public static void main(String[] args) {
        CustomTree tree = new CustomTree("0");
        for (int i = 1; i <= 5; i++) {
            tree.add(String.valueOf(i));
        }
//        System.out.println("Expected 3, actual is " + ((CustomTree) tree).getParent("8"));
//        tree.remove("5");
//        System.out.println("Expected null, actual is " + ((CustomTree) tree).getParent("11"));
//        System.out.println(tree);
        BTreePrinter.printNode(tree.getRoot());
        System.out.println(tree.size());
        System.out.println(tree.getParent("129"));
    }

    public CustomTree() {
        root = new Entry<>("0");
    }

    public CustomTree(String s) {
        root = new Entry<>(s);
    }

    @Override
    public int size() {
        int sizeFromRoot = size(root);
        return sizeFromRoot > 1 ? sizeFromRoot - 1 : 0;
    }

    public int size(Entry<String> entry) {
        if (entry == null)
            return 0;
        else
            return 1 + size(entry.getLeftChild()) + size(entry.getRightChild());
    }

    @Override
    public boolean add(String s) {
        Entry<String> nodeWithAvailableChildren = null;
        Queue<Entry<String>> queue = new LinkedList<>(Arrays.asList(root));
        while (queue.size() > 0) {
            Entry<String> entry = queue.remove();
            if (entry.isAvailableToAddChildren()) {
                nodeWithAvailableChildren = entry;
                break;
            } else {
                queue.add(entry.getLeftChild());
                queue.add(entry.getRightChild());
            }
        }
        return nodeWithAvailableChildren.addChild(new Entry<String>(s, nodeWithAvailableChildren));
    }

    @Override
    public boolean remove(Object o) {
        if (o.getClass() != String.class)
            throw new UnsupportedOperationException(o + " is not a String");
        return super.remove(o);
    }

    public Entry<String> getRoot() {
        return root;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String s) {
        Entry<String> parent = null;
        Queue<Entry<String>> queue = new LinkedList<>(Arrays.asList(root));
        while (queue.size() > 0) {
            Entry<String> entry = queue.remove();
            if (
                    s.equals(entry.getElementName()) ||
                    s.equals(entry.getRightChild().getElementName())
                    )
            {
                return entry.getElementName();
            } else {
                queue.add(entry.getLeftChild());
                queue.add(entry.getRightChild());
            }
        }

        return null;
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

        public Entry(String elementName, Entry<T> parent) {
            this.elementName = elementName;
            this.parent = parent;
            this.lineNumber = parent == null ? 0 : parent.lineNumber + 1;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public Entry(String elementName) {
            this.elementName = elementName;
            this.lineNumber = 0;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            availableToAddLeftChildren = (leftChild == null);
            availableToAddRightChildren = (rightChild == null);
        }

        boolean isAvailableToAddChildren() {
            checkChildren();
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        boolean addChild(Entry<T> entry) {
            if (availableToAddLeftChildren)
                leftChild = entry;
            else if (availableToAddRightChildren)
                rightChild = entry;
            else
                return false;
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

        public String getElementName() {
            return elementName;
        }
    }
}

