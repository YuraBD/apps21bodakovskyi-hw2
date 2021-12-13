package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack<E> {
    private ImmutableLinkedList<E> elements;

    public Stack() {
        elements = new ImmutableLinkedList<>();
    }

    public void push(E e) {
        elements = elements.addLast(e);
    }

    public E pop() {
        E el = elements.getLast();
        if (el == null) {
            return null;
        }
        elements = elements.removeLast();
        return  el;
    }

    public E peek() {
        return elements.getLast();
    }
}
