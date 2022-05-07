package com.datastructures.bst;

public class BST {
    private Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void interactiveInsertion(int toInsert) {
        if (root == null) {
            this.root = new Node(toInsert);
        } else {
            Node aux = root;

            while (aux != null) {
                if (toInsert < aux.data) {
                    if (aux.left == null) {
                        Node newNode = new Node(toInsert);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        Node newNode = new Node(toInsert);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public void recursiveInsertion(int toInsert) {
        if (root == null) {
            this.root = new Node(toInsert);
        } else {
            recursiveInsertion(root, toInsert);
        }
    }

    private void recursiveInsertion(Node node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                Node newNode = new Node(data);
                newNode.parent = node;
                node.left = newNode;
                return;
            }
            recursiveInsertion(node.left, data);
        } else {
            if (node.right == null) {
                Node newNode = new Node(data);
                newNode.parent = node;
                node.right = newNode;
                return;
            }
            recursiveInsertion(node.right, data);
        }
    }

    public Node iterativeSearch(int toFind) {
        Node aux = root;

        while (aux != null) {
            if (aux.data == toFind) return aux;
            if (toFind < aux.data) aux = aux.left;
            if (toFind > aux.data) aux = aux.right;
        }

        return null;
    }

    public Node recursiveSearch(int toFind) {
        return recursiveSearch(root, toFind);
    }

    public Node recursiveSearch(Node node, int toFind) {
        if (node == null) return null;
        else if (node.data == toFind) return node;
        else if (toFind < node.data) return recursiveSearch(node.left, toFind);
        else return recursiveSearch(node.right, toFind);
    }

    public Node findMin(Node node) {
        if (isEmpty()) return null;
        else if (node.left == null) return node;
        else return findMin(node.left);
    }

    public Node findMax(Node node) {
        if (isEmpty()) return null;
        else if (node.right == null) return node;
        else return findMax(node.right);
    }

    public Node finSuccessor(Node node) {
        if (isEmpty()) return null;

        if (node.right != null) {
            return findMin(node.right);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.data < node.data) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public Node findPredecessor(Node node) {
        if (isEmpty()) return null;

        if (node.left != null) {
            return findMax(node.left);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.data > node.data) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

    public void remove(Node toRemove) {
        if (toRemove.isLeaf()) {
            if (toRemove == this.root) {
                this.root = null;
            } else {
                if (toRemove.data < toRemove.parent.data) {
                    toRemove.parent.left = null;
                } else {
                    toRemove.parent.right = null;
                }
            }
        } else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root) {
                this.root = this.root.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.data < toRemove.parent.data) {
                    toRemove.parent.left = toRemove.left;
                } else {
                    toRemove.parent.right = toRemove.left;
                }
            }
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = this.root.right;
                this.root.parent = null;
            } else {
                toRemove.parent.right = toRemove.parent;
                if (toRemove.data < toRemove.parent.data) {
                    toRemove.parent.left = toRemove.right;
                } else {
                    toRemove.parent.right = toRemove.right;
                }
            }
        } else {
            Node successor = finSuccessor(toRemove);
            toRemove.data = successor.data;
            remove(successor);
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.printf("%d->", node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            System.out.printf("%d->", node.data);
            preOrder(node.right);
        }
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(Node node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.printf("%d->", node.data);
        }
    }

    public static BST createBST(int[] vector) {
        BST bst = new BST();

        for (int n: vector) {
            bst.interactiveInsertion(n);
        }

        return bst;
    }
}
