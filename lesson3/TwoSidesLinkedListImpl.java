package lesson3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoSidesLinkedListImpl<T> extends LinkedListImpl<T> implements TwoSidesLinkedList<T> {

    protected Entry<T> lastEntry;

    @Override
    public void addFirst(T value) {
        LinkedListSimple.Entry<T> currentEntry = new Entry<>(value);
        currentEntry.next = firstEntry;
        firstEntry = currentEntry;

        if (isEmpty()) {
            lastEntry = firstEntry;
        }

        size++;
    }

    @Override
    public void addLast(T value) {
        LinkedListSimple.Entry<T> currentEntry = new Entry<>(value);
        currentEntry.previous = lastEntry;
        lastEntry.next = currentEntry;
        lastEntry = currentEntry;

        previousEntry = currentEntry;
        size++;
    }

    @Override
    public void add(T value) {
        super.insert(value);

        lastEntry = previousEntry;
    }

    @Override
    public void removeFirst() {
        firstEntry = firstEntry.next;
        size--;
    }

    @Override
    public void removeLast() {
        // clean var. next of previous entry.
        lastEntry.previous.next = null;
        lastEntry = lastEntry.previous;
        size--;
    }

    @Override
    public T remove(T value) {

        return super.remove(value);
    }

    @Override
    public boolean contains(T value) {
        //TODO добавить метод в обычный лист.
        return false;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Entry current = firstEntry;

        int count = 0;
        while (current != null) {
            array[count++] = (T) current.value;
            current = current.next;
        }

        return array;
    }

    @Override
    public int size() {
        return super.size();
    }


    public Iterator<T> iterator() {
        return new TwoSidesLinkedListIterator();
    }

    private class TwoSidesLinkedListIterator implements Iterator<T> {

        private Entry curr;

        public TwoSidesLinkedListIterator() {
            this.curr = TwoSidesLinkedListImpl.this.firstEntry;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T value = (T) curr.value;   // значение в текущем узле
            curr = curr.next;           // следующий узел

            return value;

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
