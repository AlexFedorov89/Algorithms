package lesson2;

public interface Deque<T> {

    void insertLeft(T value) throws ArrayIndexOutOfBoundsException;

    void insertRight(T value) throws ArrayIndexOutOfBoundsException;

    T removeLeft();

    T removeRight();

    T peekLeft();

    T peekRight();


    boolean isEmpty();

    int size();

}
