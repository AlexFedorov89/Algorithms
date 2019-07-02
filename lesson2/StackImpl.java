package lesson2;

public class StackImpl<T> implements Stack<T> {

    private T[] array;

    private int size;

    public StackImpl(int size) {
        array = (T[]) new Object[size];
    }

    @Override
    public boolean push(T value) {
        if (isFull()) return false;

        array[size++] = value;

        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;

        return array[(size--) - 1];
    }

    @Override
    public T peek() {
        return array[size - 1];
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
