package lesson3;

public interface LinkedListSimple<T> {

    void insert(T value);

    T remove(T value);

    void display();

    int size();

    class Entry<T>{
        final T value;
        Entry<T> next;
        Entry<T> previous;

        public Entry(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Entry getNext() {
            return next;
        }

        public Entry<T> getPrevious() {
            return previous;
        }
    }



}
