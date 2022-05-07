package com.datastructures.bst;

public class BSTNode {
    int value = 0;
    BSTNode parent;
    BSTNode left;
    BSTNode right;

    public BSTNode(int value) {
        this.value = value;
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
