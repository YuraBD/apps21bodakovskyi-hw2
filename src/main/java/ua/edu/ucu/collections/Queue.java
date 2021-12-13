package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue<E> {
    private ImmutableLinkedList<E> elements;
    public Queue() {
        elements = new ImmutableLinkedList<>();
    }

    public E peek() {
        return elements.getFirst();
    }

    public E dequeue() {
        E el = elements.getFirst();
        if (el == null) {
            return null;
        }
        elements = elements.removeFirst();
        return el;
    }

    public void enqueue(E e) {
        elements = elements.addLast(e);
    }
}
