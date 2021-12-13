package ua.edu.ucu.collections.immutable;


public interface ImmutableList<E> {

    ImmutableList<E> add(E e);

    ImmutableList<E> add(int index, E e);

    ImmutableList<E> addAll(E[] c);

    ImmutableList<E> addAll(int index, E[] c);

    E get(int index);

    ImmutableList<E> remove(int index);

    ImmutableList<E> set(int index, E e);

    int indexOf(E e);

    int size();

    ImmutableList<E> clear();

    boolean isEmpty();

    Object[] toArray();

    E[] toArray(E[] a);

    @Override
    String toString();
}
