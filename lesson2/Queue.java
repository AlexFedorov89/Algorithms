package lesson2;

public interface Queue<T> {

    boolean insert(T value);

    T remove();

    T peek();

    boolean isFull();

    boolean isEmpty();

    int size();

}
