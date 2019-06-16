package Lesson1;

public interface Array<T> extends Cloneable {
    void add(T value);

    T get(int index);

    int size();

    void remove(int index);

    default boolean content(T value){

        return indexOf(value) != -1;
    }

    int indexOf(T value);

    boolean isEmpty();

    void sortBubble();

    void sortSelection();

    void sortInsertion();

}
