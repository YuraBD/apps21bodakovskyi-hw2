package ua.edu.ucu.collections.immutable;

import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public final class ImmutableLinkedList<E> implements ImmutableList<E> {
    private final int size;
    private final Node<E> first;
    private final Node<E> last;

    public ImmutableLinkedList(E[] elements) {
        if (elements.length == 0) {
            size = 0;
            first = null;
            last = null;
            return;
        }
        Node<E> first = new Node<>();
        first.setValue(elements[0]);
        Node<E> prevNode = first;
        Node<E> currNode = first;
        for (int i = 1; i < elements.length; i++) {
            currNode = new Node<>();
            currNode.setValue(elements[i]);
            prevNode.setNext(currNode);
            currNode.setPrevious(prevNode);
            prevNode = currNode;
        }
        size = elements.length;
        this.first = first;
        this.last = currNode;
    }

    public ImmutableLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    public ImmutableLinkedList(Node<E> first) {
        this.first = first;
        int size = 1;
        Node<E> currNode = first;
        while (currNode.getNext() != null) {
            size++;
            currNode = currNode.getNext();
        }
        this.size = size;
        this.last = currNode;
    }

    @Override
    public ImmutableLinkedList<E> add(E e) {
        return addLast(e);
    }

    @Override @SneakyThrows
    public ImmutableLinkedList<E> add(int index, E e) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return this.addFirst(e);
        }
        Node<E> copyFirst = this.getLinkedListCopy();
        Node<E> newNode = new Node<>();
        newNode.setValue(e);
        if (copyFirst == null) {
            return new ImmutableLinkedList<>(newNode);
        }
        Node<E> currNode = copyFirst;
        for (int i = 1; i < index; i++) {
            currNode = currNode.getNext();
        }
        newNode.setPrevious(currNode);
        newNode.setNext(currNode.getNext());
        newNode.getNext().setPrevious(newNode);
        newNode.getPrevious().setNext(newNode);
        return new ImmutableLinkedList<>(copyFirst);
    }

    @Override
    public ImmutableLinkedList<E> addAll(E[] c) {
        Node<E> copyFirst = this.getLinkedListCopy();
        if (copyFirst == null) {
            return new ImmutableLinkedList<>(c);
        }
        Node<E> copyLast = copyFirst;
        while (copyLast.getNext() != null) {
            copyLast = copyLast.getNext();
        }
        for (E el : c) {
            copyLast.setNext(new Node<E>(copyLast, null, el));
            copyLast = copyLast.getNext();
        }
        return new ImmutableLinkedList<>(copyFirst);
    }

    @Override
    public ImmutableLinkedList<E> addAll(int index, E[] c) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> copyFirst = this.getLinkedListCopy();
        if (copyFirst == null) {
            return new ImmutableLinkedList<>(c);
        }
        Node<E> currNode = copyFirst;
        if (index == 0) {
            for (int i = c.length - 1; i >= 0; i--) {
                copyFirst.setPrevious(new Node<E>(null, copyFirst, c[i]));
                copyFirst = copyFirst.getPrevious();
            }
            return new ImmutableLinkedList<>(copyFirst);
        }
        for (int i = 1; i < index; i++) {
            currNode = currNode.getNext();
        }
        Node<E> prevIndNode = currNode.getNext();
        for (E el : c) {
            currNode.setNext(new Node<E>(currNode, null, el));
            currNode = currNode.getNext();
        }
        currNode.setNext(prevIndNode);
        prevIndNode.setPrevious(currNode);
        return new ImmutableLinkedList<>(copyFirst);
    }

    @Override
    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> currNode = first;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getValue();
    }

    @Override
    public ImmutableLinkedList<E> remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> copyFirst = this.getLinkedListCopy();
        if (copyFirst == null) {
           return new ImmutableLinkedList<>();
        }
        if (size == 1) {
            return new ImmutableLinkedList<>();
        }
        if (index == 0) {
            copyFirst = copyFirst.getNext();
            copyFirst.setPrevious(null);
            return new ImmutableLinkedList<>(copyFirst);
        }
        Node<E> currNode = copyFirst;
        for (int i = 1; i <= index; i++) {
            currNode = currNode.getNext();
        }
        currNode.getPrevious().setNext(currNode.getNext());
        if (currNode.getNext() != null) {
            currNode.getNext().setPrevious(currNode.getPrevious());
        }
        return new ImmutableLinkedList<>(copyFirst);
    }

    @Override
    public ImmutableLinkedList<E> set(int index, E e) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> copyFirst = this.getLinkedListCopy();
        if (copyFirst == null) {
            return new ImmutableLinkedList<>();
        }
        if (index == 0) {
            copyFirst.setValue(e);
            return new ImmutableLinkedList<>(copyFirst);
        }
        Node<E> currNode = copyFirst;
        for (int i = 1; i <= index; i++) {
            currNode = currNode.getNext();
        }
        currNode.setValue(e);
        return new ImmutableLinkedList<>(copyFirst);
    }

    @Override
    public int indexOf(Object e) {
        Node<E> currNode = first;
        int i = 0;
        while (currNode != null) {
            if (currNode.getValue().equals(e)) {
                return i;
            }
            currNode = currNode.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList<E> clear() {
        return new ImmutableLinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<E> currNode = first;
        for (int i = 0; i < size; i++) {
            arr[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        return arr;
    }

    @Override @SuppressWarnings("unchecked")
    public E[] toArray(E[] a) {
        if (a.length < size) {
            a = (E[]) Arrays.copyOf(a, size, a.getClass());
        }
        Node<E> currNode = first;
        for (int i = 0; i < size; i++) {
            a[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        for (int i = size; i < a.length; i++) {
            a[i] = null;
        }
        return a;
    }

    private Node<E> getLinkedListCopy() {
        if (first == null) {
            return null;
        }
        Node<E> firstCopy = new Node<>();
        firstCopy.setValue(first.getValue());
        Node<E> prevNodeCopy = firstCopy;
        Node<E> currNodeCopy = null;
        Node<E> currNode = first;
        for (int i = 1; i < this.size; i++) {
            currNode = currNode.getNext();
            currNodeCopy = new Node<>(prevNodeCopy, null, currNode.getValue());
            prevNodeCopy.setNext(currNodeCopy);
            prevNodeCopy = currNodeCopy;
        }
        return firstCopy;
    }


    public ImmutableLinkedList<E> addFirst(E e) {
        Node<E> copyFirst = this.getLinkedListCopy();
        Node<E> newNode = new Node<>();
        newNode.setValue(e);
        if (copyFirst == null) {
            return new ImmutableLinkedList<>(newNode);
        }
        newNode.setNext(copyFirst);
        copyFirst.setPrevious(newNode);
        return new ImmutableLinkedList<>(newNode);

    }

    public ImmutableLinkedList<E> addLast(E e) {
        Node<E> copyFirst = this.getLinkedListCopy();
        Node<E> newNode = new Node<>();
        newNode.setValue(e);
        if (copyFirst == null) {
            return new ImmutableLinkedList<>(newNode);
        }
        Node<E> copyLast = copyFirst;
        while (copyLast.getNext() != null) {
            copyLast = copyLast.getNext();
        }
        newNode.setPrevious(copyLast);
        copyLast.setNext(newNode);
        return new ImmutableLinkedList<>(copyFirst);
    }

    public Node<E> getHead() {
        return first;
    }

    public Node<E> getTail() {
        return last;
    }

    public E getFirst() {
        if (first == null) {
            return null;
        }
        return first.getValue();
    }

    public E getLast() {
        if (last == null) {
            return null;
        }
        return last.getValue();
    }

    public ImmutableLinkedList<E> removeFirst() {
        return (ImmutableLinkedList<E>) this.remove(0);
    }

    public ImmutableLinkedList<E> removeLast() {
        return (ImmutableLinkedList<E>) this.remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        Node<E> currNode = first;
        for (int i = 0; i < size; i++) {
            b.append(currNode.getValue());
            currNode = currNode.getNext();
            if (i == size - 1) {
                break;
            }
            b.append(", ");
        }
        b.append("]");
        return b.toString();
    }
}
