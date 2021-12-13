package ua.edu.ucu.collections.immutable;

import lombok.SneakyThrows;

import java.util.Arrays;

public final class ImmutableArrayList<E> implements ImmutableList<E> {
    private final Object[] elements;

    public ImmutableArrayList(E[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }


    public ImmutableArrayList() {
        elements = new Object[0];
    }

    @SuppressWarnings("unchecked")
    private ImmutableArrayList<E> immutableArrayListFromObjectArray(Object[] arr) {
        return new ImmutableArrayList<>((E[]) arr);
    }

    @Override
    public ImmutableArrayList<E> add(E e) {
        Object[] newElements = Arrays.copyOf(elements, elements.length + 1);
        newElements[newElements.length - 1] = e;
        return this.immutableArrayListFromObjectArray(newElements);
    }

    @Override
    public ImmutableArrayList<E> add(int index, E e) {
        if (index > elements.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        return this.immutableArrayListFromObjectArray(newElements);
    }

    @Override
    public ImmutableArrayList<E> addAll(E[] c) {
        Object[] newElements = new Object[elements.length + c.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        System.arraycopy(c, 0, newElements, elements.length, c.length);
        return this.immutableArrayListFromObjectArray(newElements);
    }

    @Override
    public ImmutableArrayList<E> addAll(int index, E[] c) {
        Object[] newElements = new Object[elements.length + c.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(c, 0, newElements, index, c.length);
        System.arraycopy(elements, index, newElements, index + c.length, elements.length - index);
        return  this.immutableArrayListFromObjectArray(newElements);
    }

    @Override @SneakyThrows @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index > elements.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    @Override @SneakyThrows
    public ImmutableArrayList<E> remove(int index) {
        if (index > elements.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newElements = new Object[elements.length - 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(elements, index + 1, newElements, index, elements.length - index - 1);
        return this.immutableArrayListFromObjectArray(newElements);
    }

    @Override @SneakyThrows
    public ImmutableArrayList<E> set(int index, E e) {
        if (index > elements.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newElements = new Object[elements.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index + 1, newElements, index + 1, elements.length - index - 1);
        return this.immutableArrayListFromObjectArray(newElements);
    }

    @Override
    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableArrayList<E> clear() {
        return new ImmutableArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }

    @Override @SuppressWarnings("unchecked")
    public E[] toArray(E[] a) {
        if (a.length < elements.length) {
            return (E[]) Arrays.copyOf(elements, elements.length, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, elements.length);
        for (int i = elements.length; i < a.length; i++) {
            a[i] = null;
        }
        return a;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(elements);
    }
}
