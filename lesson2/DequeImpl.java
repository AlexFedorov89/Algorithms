package lesson2;

import java.util.Arrays;

public class DequeImpl<T> implements Deque<T> {


    T[] queue;
    int maxSize, size, head, tail = -1;

    public DequeImpl(int maxSize) {
        this.maxSize = maxSize;
        queue = (T[]) new Object[maxSize];
    }

    private void allocateNewArray(int startingIndex) {
        int newLength = (size == 0) ? 4 : size * 2;

        T[] newArray = (T[]) new Object[newLength];

        if (size > 0) {
            int targetIndex = startingIndex;

            // Копируем содержимое...
            // Если массив не закольцован, просто копируем элементы.
            // В противном случае, копирует от head до конца, а затем от начала массива до tail.

            // Если tail меньше, чем head, переходим в начало.
            if (tail < head) {
                // Копируем _items[head].._items[end] в newArray[0]..newArray[N].
                for (int index = head; index < queue.length; index++) {
                    newArray[targetIndex] = queue[index];
                    targetIndex++;
                }

                // Копируем _items[0].._items[tail] в newArray[N+1]..
                for (int index = 0; index <= tail; index++) {
                    newArray[targetIndex] = queue[index];
                    targetIndex++;
                }
            } else {
                // Копируем _items[head].._items[tail] в newArray[0]..newArray[N]
                for (int index = head; index <= tail; index++) {
                    newArray[targetIndex] = queue[index];
                    targetIndex++;
                }
            }


            head = startingIndex;
            tail = targetIndex - 1;
        } else {
            // Массив пуст.
            head = 0;
            tail = -1;
        }

        queue = newArray;
    }

    @Override
    public void insertLeft(T value) {
        // Проверим, необходимо ли увеличение массива:
        if (queue.length == size)
        {
            allocateNewArray(1);
        }

        // Так как массив не заполнен и _head больше 0,
        // мы знаем, что есть место в начале массива.
        if (head > 0) {
            head--;
        } else {
            // В противном случае мы должны закольцеваться.
            head = queue.length - 1;
        }

        queue[head] = value;


        size++;

        if (size == 1) {
            // Если мы добавили первый элемент в пустую
            // очередь, он же будет и последним, поэтому
            // нужно обновить и _tail.
            tail = head;
        }
    }

    @Override
    public void insertRight(T value) {
        // Проверим, необходимо ли увеличение массива:
        if (queue.length == size) {
            allocateNewArray(0);
        }

        // Теперь, когда у нас есть подходящий массив,
        // если _tail в конце массива, нам надо перейти в начало.
        if (tail == queue.length - 1) {
            tail = 0;
        } else {
            tail++;
        }

        queue[tail] = value;
        size++;

        if (size == 1) {
            // Если мы добавили последний элемент в пустую
            // очередь, он же будет и первым, поэтому
            // нужно обновить и _head.
            head = tail;
        }
    }

    @Override
    public T removeLeft() {
        if (isEmpty()) {
            return null;
        }

        T value = queue[head];

        if (head == queue.length - 1) {
            // Если head установлен на последнем индексе, переходим к началу массива.
            head = 0;
        } else {
            // Переходим к следующему элементу.
            head++;
        }

        size--;

        return value;
    }


    @Override
    public T removeRight() {
        if (isEmpty()) {
            return null;
        }

        T value = queue[tail];

        if (tail == 0) {
            // Если tail установлен на начало массива, переходим к концу.
            tail = queue.length - 1;
        } else {
            // Переходим к предыдущему элементу.
            tail--;
        }

        size--;

        return value;
    }

    @Override
    public T peekLeft() {

        if (isEmpty())
        {
            return null;
        }

        return queue[head];
    }

    @Override
    public T peekRight() {

        if (isEmpty())
        {
            return null;
        }

        return queue[tail];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
