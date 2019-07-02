package lesson3;

import java.util.Iterator;

public interface TwoSidesLinkedList<T> extends Iterable<T> {

    void addFirst(T value);

    void addLast(T value);

    void add(T value);

    void removeFirst();

    void removeLast();

    T remove(T value);

    void display();

    boolean contains(T value);

    int size();

}
