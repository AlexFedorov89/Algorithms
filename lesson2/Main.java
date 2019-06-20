package lesson2;

public class Main {
    public static void main(String[] args) {

        // 1. Реализовать рассмотренные структуры данных в консольных программах.

        //testStack();
        //testQueue();

//        // 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
//        String stringToReverse = "Reverse this string!";
//        Stack<Character> reverseString = new StackImpl<>(stringToReverse.length());
//
//        for (int i = 0; i < stringToReverse.length(); i++) {
//            reverseString.push(stringToReverse.charAt(i));
//        }
//
//        while ( !reverseString.isEmpty() ){
//            System.out.print(reverseString.pop());
//        }

        // 3. Создать класс для реализации дека.
        Deque<Integer> myDeque = new DequeImpl<>(5);

        myDeque.insertRight(1);
        myDeque.insertRight(2);
        myDeque.insertRight(3);
        myDeque.insertRight(4);
        myDeque.insertLeft(5);
//        myDeque.insertRight(7);
//        myDeque.insertRight(8);

        //System.out.println(myDeque.removeRight());
        //System.out.println(myDeque.removeLeft());
//        System.out.println(myDeque.removeLeft());
//        myDeque.insertRight(7);
//        myDeque.insertRight(7);
//        myDeque.insertRight(7);
//        myDeque.insertRight(7);
//        myDeque.insertRight(7);
//        myDeque.insertRight(9);

        System.out.println(myDeque.toString());

    }

    private static void testQueue() {
        Queue<Integer> myQueue = new QueueImpl<>(5);
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        myQueue.insert(4);
        myQueue.insert(5);
        myQueue.insert(6);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());

        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        myQueue.insert(6);
        myQueue.insert(7);
        System.out.println(myQueue.peek());
    }

    private static void testStack() {
        Stack<Integer> myStack = new StackImpl<>(5);

        getPrintln(myStack, 1);
        getPrintln(myStack, 2);
        getPrintln(myStack, 3);
        getPrintln(myStack, 4);
        getPrintln(myStack, 5);
        getPrintln(myStack, 6);

        System.out.println("Stack is full: " + myStack.isFull());
        System.out.println("Stack size is: " + myStack.size());

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    private static void getPrintln(Stack<Integer> myStack, int value) {
        System.out.println(myStack.push(value));
    }
}
