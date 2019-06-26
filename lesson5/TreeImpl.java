package lesson5;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {
    private Node<E> root;

    // Auxiliary variables.
    private Node<E> parent;
    private Node<E> current;

    private int currentLevel;

    private int size;

    @Override
    public boolean add(E value) {

        if (isEmpty()) {
            currentLevel++;

            root = new Node<>(value);

            size++;

            return true;
        }

        if (!find(value)) {

            if (parent.isLeaf()) {
                currentLevel++;
            }

            if (parent.shouldBeLeft(value)) {
                parent.setLeftChild(new Node<>(value));
            } else {
                parent.setRightChild(new Node<>(value));
            }
        } else {
            return false;
        }

        cleanAuxiliaryVars();

        size++;

        return true;

    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public boolean remove(E value) {

        if (!find(value)) {
            return false;
        }

        Node<E> removedNode = current;

        if (removedNode.isLeaf()) {
            removeLeafNode(parent, removedNode);
        } else if (hasOnlySingleChildNode(removedNode)) {
            removeNodeWithSingleChild(parent, removedNode);
        } else {
            removeCommonNode(parent, removedNode);
        }

        cleanAuxiliaryVars();

        size--;

        return true;
    }

    private void cleanAuxiliaryVars() {
        current = null;
        parent = null;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode = removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();

        if (removedNode == root) {
            root = childNode;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(childNode);
        } else {
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root) {
            root = null;

            currentLevel = 0;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    private boolean hasOnlySingleChildNode(Node<E> removedNode) {
        return removedNode.getLeftChild() != null ^ removedNode.getRightChild() != null;
    }

    @Override
    public boolean find(E value) {
        Node<E> currentNode = root;

        cleanAuxiliaryVars();

        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                current = currentNode;

                return true;
            } else {
                parent = currentNode;

                if (currentNode.shouldBeLeft(value)) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }
        }

        return false;
    }


    @Override
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return root == null;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown value: " + mode);
        }
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
        System.out.println(current);
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.println(current);
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.println(current);
        inOrder(current.getRightChild());
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}
