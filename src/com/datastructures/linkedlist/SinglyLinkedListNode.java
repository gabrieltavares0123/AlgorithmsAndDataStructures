package com.datastructures.linkedlist;

public class SinglyLinkedListNode {
    private int value;
    private SinglyLinkedListNode next = null;

    public SinglyLinkedListNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    public SinglyLinkedListNode getNext() {
        return this.next;
    }
}
