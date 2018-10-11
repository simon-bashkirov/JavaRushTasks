package com.javarush.task.task36.task3604;


import com.javarush.task.task20.task2028.NodeAdapter;
import com.javarush.task.task36.task3604.RedBlackTree.Node;

public class CustomNodeAdapter implements NodeAdapter {
    private enum NodeColorANSI {
        RED((char)27 + "[31m"),
        BLACK((char)27 + "[30m");

        private String ansiColorCode;

        NodeColorANSI(String ansiColorCode) {
            this.ansiColorCode = ansiColorCode;
        }

        private static String getAnsiColorCode(RedBlackTree.Color color) {
            return valueOf(color.toString()).ansiColorCode;
        }
    }

    Node node;

    public CustomNodeAdapter(Node node) {
        this.node = node;
    }

    public NodeAdapter getLeft() {
        Node left = node.getLeft();
        return left == null ? null : new CustomNodeAdapter(left);
    }

    public NodeAdapter getRight() {
        Node right = node.getRight();
        return right == null ? null : new CustomNodeAdapter(right);
    }

    public String getValue() {
        return NodeColorANSI.getAnsiColorCode(node.getColor()) + node.getElement();
    }
}
