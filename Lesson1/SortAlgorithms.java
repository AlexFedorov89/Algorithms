package Lesson1;

public class SortAlgorithms {

    public static <T extends Comparable<? super T>> T[] bubleSort(T[] array) {
        boolean F;

        for (int i = 0; i < array.length; i++) {
            F = false;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    F = true;
                }

                if (F == false) break;
            }
        }

        return array;
    }

    public static <T extends Comparable<? super T>> T[] selectionSort(T[] array) {
        for (int min = 0; min < array.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.length; j++) {
                if (array[j].compareTo(array[least]) < 0) {
                    least = j;
                }
            }
            T tmp = array[min];
            array[min] = array[least];
            array[least] = tmp;
        }

        return array;
    }

    public static <T extends Comparable<? super T>> T[] insertionSort(T[] array) {
        T key;
        int j;

        for (int i = 0; i < array.length; i++) {
            key = array[i];
            j = i;
            while (j > 0 && array[j - 1].compareTo(key) > 0) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = key;
        }


        return array;
    }


}
