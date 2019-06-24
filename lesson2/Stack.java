package lesson2;

public interface Stack<T> {

    boolean push(T value);

    T pop();

    T peek();

    boolean isFull();

    boolean isEmpty();

    int size();

}
