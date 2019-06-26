package lesson5;

public interface Tree<T> {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }
    boolean add(T value);

    boolean remove(T value);

    boolean find(T value);

    int size();

    void traverse(TraverseMode mode);

    void display();
}
