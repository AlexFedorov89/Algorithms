package Lesson1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    private static int COUNT_ELEMENTS = 1000000;

    public static void main(String[] args) throws CloneNotSupportedException {
        Random rd = new Random();


        // 1. Создать массив большого размера (миллион элементов).
        ArrayListImpl<Integer> myArray = new ArrayListImpl<>(COUNT_ELEMENTS);

        // 3. Заполнить массив случайными числами.
        for (int i = 0; i < COUNT_ELEMENTS; i++) {
            myArray.add(rd.nextInt(100));
        }

        ArrayListImpl<Integer> myArray2 =  myArray.clone();
        Array<Integer> myArray3         =  myArray.clone();

        // 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.

        long startTime;
        long stopTime;

        startTime = System.nanoTime();
        myArray.sortBubble();
        stopTime = System.nanoTime();
        System.out.printf("Время выполнения сортировки методом Пузырька: %d%n" , TimeUnit.NANOSECONDS.toMicros(stopTime - startTime));

        startTime = System.nanoTime();
        myArray2.sortSelection();
        stopTime = System.nanoTime();
        System.out.printf("Время выполнения сортировки методом Выбора: %d%n" , TimeUnit.NANOSECONDS.toMicros(stopTime - startTime));

        startTime = System.nanoTime();
        myArray3.sortInsertion();
        stopTime = System.nanoTime();
        System.out.printf("Время выполнения сортировки методом Вставки: %d%n" , TimeUnit.NANOSECONDS.toMicros(stopTime - startTime));

    }

}
