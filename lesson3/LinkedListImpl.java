package lesson3;

import java.util.Iterator;

public class LinkedListImpl<T> implements LinkedListSimple<T> {

    protected Entry<T> firstEntry;
    protected Entry<T> previousEntry;
    protected int size;

    @Override
    public void insert(T value) {
        Entry currentEntry = new LinkedListSimple.Entry<>(value);

        if (size == 0) {
            firstEntry = currentEntry;
        } else {
            previousEntry.next = currentEntry;
            currentEntry.previous = previousEntry;
        }

        previousEntry = currentEntry;

        size++;
    }

    @Override
    public T remove(T value) {

        Entry currentEntry = firstEntry;
        Entry prevEntry = null;

        T result = null;

        while (currentEntry != null) {
            if (currentEntry.value.equals(value)) {

                result = value;
                size--;

                if (currentEntry == firstEntry) {
                    // Clean all variables.
                    if (size == 0) {
                        firstEntry = null;
                        previousEntry = null;
                    } else {
                        firstEntry = firstEntry.next;
                    }
                } else {
                    // last el.
                    if (currentEntry.next == null) {
                        previousEntry = prevEntry;
                    }
                    else {
                        currentEntry.next.previous = prevEntry;
                    }

                    prevEntry.next = currentEntry.next;



                }

                break;
            }

            prevEntry = currentEntry;
            currentEntry = currentEntry.next;
        }

        return result;

    }


    @Override
    public void display() {
        Entry current = firstEntry;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
