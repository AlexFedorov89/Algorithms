package Lesson1;


import java.util.Arrays;

// 2. Написать методы удаления, добавления, поиска элемента массива.
public class ArrayListImpl<E extends Object & Comparable<? super E>> implements Array<E>, Cloneable {
    private int size;
    private static int DEFAULT_SIZE = 10;
    private E[] array;

    public ArrayListImpl(int size) {
        this.array = (E[]) new Object[size];
    }

    public ArrayListImpl() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void add(E value) {
        increaseArray();
        array[size++] = value;
    }

    private void increaseArray() {
        if (array.length == size) {
            array = Arrays.copyOf(array, size * 2 + 1);
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return array[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        size--;

        for (int i = index; i < array.length - 1; i++) {
            if (array[i] == null) break;

            array[i] = array[i + 1];
        }
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void sortBubble() {

        SortAlgorithms.bubleSort(array);

    }

    @Override
    public void sortSelection() {
        SortAlgorithms.selectionSort(array);
    }

    @Override
    public void sortInsertion() {
        SortAlgorithms.insertionSort(array);
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < size; i++) {
            result += array[i];
            result += (i != (size - 1))?" ":"";
        }


        return result;
    }

    @Override
    protected ArrayListImpl clone() throws CloneNotSupportedException {
        ArrayListImpl arrayListCopy = (ArrayListImpl) super.clone();
        arrayListCopy.array = Arrays.copyOf(array, array.length);

        return arrayListCopy;
    }
}
