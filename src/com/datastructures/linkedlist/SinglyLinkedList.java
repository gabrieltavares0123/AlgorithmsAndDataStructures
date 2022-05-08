package com.datastructures.linkedlist;

public class SinglyLinkedList {
    private SinglyLinkedListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public SinglyLinkedListNode getHead() {
        return this.head;
    }

    public void insertAllAtHead(int[] vector) {
        for (int n : vector) {
            insertAtHead(n);
        }
    }

    public void insertAllOrdered(int[] vector) {
        for (int n : vector) {
            insertOrdered(n);
        }
    }

    public void insertAtHead(int toInsert) {
        if (this.head == null) {
            this.head = new SinglyLinkedListNode(toInsert);
        } else {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(toInsert);
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }

    public void insertOrdered(int toInsert) {
        if (this.head == null) {
            this.head = new SinglyLinkedListNode(toInsert);
        } else {
            SinglyLinkedListNode aux = this.head;
            if (toInsert < this.head.getValue()) {
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(toInsert);
                newNode.setNext(this.head);
                this.head = newNode;
            } else {
                while (aux.getNext() != null && toInsert > aux.getNext().getValue()) {
                    aux = aux.getNext();
                }
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(toInsert);
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
            }
        }
    }

    public SinglyLinkedListNode find(int toFind) {
        if (this.head == null) {
            System.out.println("A lista está vazia.");
            return null;
        } else {
            SinglyLinkedListNode aux = this.head;
            while (aux != null && aux.getValue() != toFind) {
                aux = aux.getNext();
            }
            return aux;
        }
    }

    public void update(int toFind, int newValue) {
        if (this.head == null) {
            System.out.println("A lista está vazia.");
        } else {
            SinglyLinkedListNode foundNode = find(toFind);
            if (foundNode != null) {
                foundNode.setValue(newValue);
            } else {
                System.out.println("O nó que deseja remover não encontra-se na lista.");
            }
        }
    }

    public void remove(int toRemove) {
        if (this.head == null) {
            System.out.println("A lista está vazia.");
        } else {
            if (toRemove == this.head.getValue()) {
                this.head = this.head.getNext();
            } else {
                SinglyLinkedListNode aux = this.head;
                while (aux.getNext() != null && aux.getNext().getValue() != toRemove) {
                    aux = aux.getNext();
                }

                if (aux == null || aux.getNext() == null){
                    System.out.println("Nó com o valor indicado não encontrado.");
                } else {
                    SinglyLinkedListNode next = aux.getNext().getNext();
                    aux.setNext(next);
                    System.out.printf("Nó com valor %d removido.", toRemove);
                    System.out.println();
                }
            }
        }
    }

    public void print() {
        if (this.head == null) {
            System.out.println("A lista está vazia.");
        } else {
            SinglyLinkedListNode aux = this.head;
            System.out.print("Output: ");
            while (aux != null) {
                System.out.printf("%d->", aux.getValue());
                aux = aux.getNext();
            }
            System.out.println();
        }
    }

    public void clear() {
        this.head = null;
    }

    public static void main(String[] args) {
        int[] vector = {10, 7, 3, 6, 3, 18, 23, 65, 21, 15, 54, 33};
        System.out.println("=====------Test insertion unordered------=====");
        String expectedUnordered = "33->54->15->21->65->23->18->3->6->3->7->10";
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAllAtHead(vector);
        linkedList.print();
        System.out.println("Expected: " + expectedUnordered);

        System.out.println();

        System.out.println("=====------Test Search------=====");
        System.out.println("-Find 3");
        SinglyLinkedListNode find3 = linkedList.find(3);
        if (find3 != null) {
            System.out.println(find3.getValue());
        } else {
            System.out.println("Não encontrado.");
        }
        System.out.println("-Find 99");
        SinglyLinkedListNode find99 = linkedList.find(99);
        if (find99 != null) {
            System.out.println(find99.getValue());
        } else {
            System.out.println("Não encontrado.");
        }

        System.out.println();

        System.out.println("=====------Test insert ordered------=====");
        String expectedOrdered = "3->3->6->7->10->15->18->21->23->33->54->65";
        linkedList.clear();
        linkedList.insertAllOrdered(vector);
        linkedList.print();
        System.out.println("Expected: " + expectedOrdered);

        System.out.println();

        System.out.println("=====------Test remove------=====");
        System.out.println("-Remove 10");
        linkedList.remove(10);
        System.out.println("-Remove 99");
        linkedList.remove(99);
        linkedList.print();
    }
}
