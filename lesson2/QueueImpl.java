package lesson2;

public class QueueImpl<T> implements Queue<T> {

    private T[] queue;
    private int maxSize, size, front, rear = -1;

    public QueueImpl(int maxSize) {
        this.maxSize = maxSize;

        queue = (T[]) new Object[maxSize];
    }

    @Override
    public boolean insert(T value) {
        if (rear == maxSize - 1)
        {
            rear = -1;
        }

        queue[++rear] = value;

        size++;

        return true;
    }

    @Override
    public T remove() {
        T tmp = queue[front++];

        if (front == maxSize){
            front = 0;
        }

        size--;

        return tmp;
    }

    @Override
    public T peek() {
        return queue[front];
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
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
