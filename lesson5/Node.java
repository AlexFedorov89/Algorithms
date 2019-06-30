package lesson5;

public class Node<E extends Comparable<? super E>> {
    private Node<E> parent;
    private Node<E> childLeftNode;
    private Node<E> childRightNode;

    private final E value;

    public Node(E value) {
        this.value = value;
    }

    public Node<E> getLeftChild() {
        return childLeftNode;
    }

    public void setLeftChild(Node<E> childLeftNode) {
        this.childLeftNode = childLeftNode;
    }

    public Node<E> getRightChild() {
        return childRightNode;
    }

    public void setRightChild(Node<E> childRightNode) {
        this.childRightNode = childRightNode;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    public E getValue() {
        return value;
    }

    public boolean shouldBeLeft(E value) {
        return value.compareTo(getValue()) < 0;
    }
}
