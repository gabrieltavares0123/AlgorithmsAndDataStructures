package com.datastructures.bst;

public class BST {
    private Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void interactiveInsertion(int toInsert) {
        // Se a árvore está vazia, cria o nó inicial.
        if (root == null) {
            this.root = new Node(toInsert);
        } else {
            Node aux = root;

            while (aux != null) {
                if (toInsert < aux.data) { // Checa se deve navegar para esquerda.
                    if (aux.left == null) { // Checa se chegou na posição de inserção.
                        Node newNode = new Node(toInsert);
                        aux.left = newNode;
                        newNode.parent = aux;
                        // Inserções acontecem nas folhas. Chegando nesse ponto, não é mais necessário caminhar na árvore.
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

    // O mínimo é o nó folha mais à esquerda da árvore.
    public Node findMin(Node node) {
        if (isEmpty()) return null;
        else if (node.left == null) return node;
        else return findMin(node.left);
    }

    // O máximo é o nó mais à direita na árvore.
    public Node findMax(Node node) {
        if (isEmpty()) return null;
        else if (node.right == null) return node;
        else return findMax(node.right);
    }

    // O sucesor é o menor valor dentre os valores maiores que o nó desejado.
    public Node finSuccessor(Node node) {
        if (isEmpty()) return null;

        // Se eu tenho uma sub-árvore à direita.
        if (node.right != null) {
            return findMin(node.right);
        }
        /* Se eu não tenho sub-árvore à direita, procuro dentre os nós pai o próximo menor nó entre os maiores
         maior que o nó desejado.*/
        else {
            Node aux = node.parent;
            while (aux != null && aux.data < node.data) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    // O predecessor é o maior valor dentre os valores menores do que o do nó desejado.
    public Node findPredecessor(Node node) {
        if (isEmpty()) return null;

        // Se eu tenho sub-árvore à esquerda.
        if (node.left != null) {
            return findMax(node.left);
        }
        /* Se eu não tenho sub-árvore à esquerda, procuro dentre os nós pai o próximo maior nó entre os menores
         menor que o nó desejado.*/
        else {
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

    public static Node createSampleBST() {
        return new Node(0);
    }
}
