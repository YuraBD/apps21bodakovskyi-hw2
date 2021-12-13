package ua.edu.ucu.collections.immutable;

public class Node<E> {
    private Node<E> previous;
    private Node<E> next;
    private E value;

    public Node() {
    }

    public Node(Node<E> prev, Node<E> next, E value) {
        this.previous = prev;
        this.next = next;
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> prev) {
        this.previous = prev;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E val) {
        this.value = val;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> ne) {
        this.next = ne;
    }
}

