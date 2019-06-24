package lesson3.tests;

import lesson3.TwoSidesLinkedListImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestTwoSidesLinkedList {
    private TwoSidesLinkedListImpl<Integer> linkedList;

    @Before
    public void beforeTestLinkedList(){
        linkedList = new TwoSidesLinkedListImpl<>();
    }

    @Test
    public void testLinkedListAdd(){
        Integer[] array = {1, 2, 3};

        linkedList.add(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);

        assertArrayEquals(array, linkedList.toArray());
    }

    @Test
    public void testLinkedListRemove(){
        Integer[] array = {2, 3, 5};

        linkedList.add(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);

        linkedList.removeFirst();
        linkedList.remove(4);
        linkedList.removeLast();

        linkedList.display();

        assertArrayEquals(array, linkedList.toArray());
    }

    @Test
    public void testLinkedListIterator(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(6);

        Integer[] array = new Integer[linkedList.size()];

        int count = 0;
        for (Integer value:linkedList){
            array[count++] = value;
        }

        assertArrayEquals(array, linkedList.toArray());

    }
}
