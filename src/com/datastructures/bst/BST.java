package com.datastructures.bst;

public class BST {
    private BSTNode root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public BSTNode getRoot() {
        return this.root;
    }

    public void interactiveInsertion(int toInsert) {
        if (root == null) {
            this.root = new BSTNode(toInsert);
        } else {
            BSTNode aux = root;

            while (aux != null) {
                if (toInsert < aux.value) {
                    if (aux.left == null) {
                        BSTNode newBSTNode = new BSTNode(toInsert);
                        aux.left = newBSTNode;
                        newBSTNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        BSTNode newBSTNode = new BSTNode(toInsert);
                        aux.right = newBSTNode;
                        newBSTNode.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public void recursiveInsertion(int toInsert) {
        if (root == null) {
            this.root = new BSTNode(toInsert);
        } else {
            recursiveInsertion(root, toInsert);
        }
    }

    private void recursiveInsertion(BSTNode BSTNode, int data) {
        if (data < BSTNode.value) {
            if (BSTNode.left == null) {
                BSTNode newBSTNode = new BSTNode(data);
                newBSTNode.parent = BSTNode;
                BSTNode.left = newBSTNode;
                return;
            }
            recursiveInsertion(BSTNode.left, data);
        } else {
            if (BSTNode.right == null) {
                BSTNode newBSTNode = new BSTNode(data);
                newBSTNode.parent = BSTNode;
                BSTNode.right = newBSTNode;
                return;
            }
            recursiveInsertion(BSTNode.right, data);
        }
    }

    public BSTNode iterativeSearch(int toFind) {
        BSTNode aux = root;

        while (aux != null) {
            if (aux.value == toFind) return aux;
            if (toFind < aux.value) aux = aux.left;
            if (toFind > aux.value) aux = aux.right;
        }

        return null;
    }

    public BSTNode recursiveSearch(int toFind) {
        return recursiveSearch(root, toFind);
    }

    public BSTNode recursiveSearch(BSTNode BSTNode, int toFind) {
        if (BSTNode == null) return null;
        else if (BSTNode.value == toFind) return BSTNode;
        else if (toFind < BSTNode.value) return recursiveSearch(BSTNode.left, toFind);
        else return recursiveSearch(BSTNode.right, toFind);
    }

    public BSTNode findMin(BSTNode BSTNode) {
        if (isEmpty()) return null;
        else if (BSTNode.left == null) return BSTNode;
        else return findMin(BSTNode.left);
    }

    public BSTNode findMax(BSTNode BSTNode) {
        if (isEmpty()) return null;
        else if (BSTNode.right == null) return BSTNode;
        else return findMax(BSTNode.right);
    }

    public BSTNode finSuccessor(BSTNode BSTNode) {
        if (isEmpty()) return null;

        if (BSTNode.right != null) {
            return findMin(BSTNode.right);
        } else {
            BSTNode aux = BSTNode.parent;
            while (aux != null && aux.value < BSTNode.value) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public BSTNode findPredecessor(BSTNode BSTNode) {
        if (isEmpty()) return null;

        if (BSTNode.left != null) {
            return findMax(BSTNode.left);
        } else {
            BSTNode aux = BSTNode.parent;
            while (aux != null && aux.value > BSTNode.value) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(BSTNode BSTNode) {
        if (BSTNode == null) return -1;
        else return 1 + Math.max(height(BSTNode.left), height(BSTNode.right));
    }

    public void remove(BSTNode toRemove) {
        if (toRemove.isLeaf()) {
            if (toRemove == this.root) {
                this.root = null;
            } else {
                if (toRemove.value < toRemove.parent.value) {
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
                if (toRemove.value < toRemove.parent.value) {
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
                if (toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = toRemove.right;
                } else {
                    toRemove.parent.right = toRemove.right;
                }
            }
        } else {
            BSTNode successor = finSuccessor(toRemove);
            toRemove.value = successor.value;
            remove(successor);
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(BSTNode BSTNode) {
        if (BSTNode != null) {
            System.out.printf("%d->", BSTNode.value);
            preOrder(BSTNode.left);
            preOrder(BSTNode.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BSTNode BSTNode) {
        if (BSTNode != null) {
            preOrder(BSTNode.left);
            System.out.printf("%d->", BSTNode.value);
            preOrder(BSTNode.right);
        }
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(BSTNode BSTNode) {
        if (BSTNode != null) {
            posOrder(BSTNode.left);
            posOrder(BSTNode.right);
            System.out.printf("%d->", BSTNode.value);
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
