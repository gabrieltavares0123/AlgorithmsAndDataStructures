package com.datastructures.bst;

public class Node {
    int data = 0;
    Node parent;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasOnlyLeftChild() {
        return left != null && right == null;
    }

    public boolean hasOnlyRightChild() {
        return right != null && left == null;
    }
}
