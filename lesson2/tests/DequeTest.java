package lesson2.tests;

import lesson2.Deque;
import lesson2.DequeImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {

    private Deque<Integer> deque;

    @Before
    public void beforeTestDeque(){
        deque = new DequeImpl<>(5);
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);


    }

    @Test
    public void testDequePeekLeft(){
        assertEquals(java.util.Optional.of(3), java.util.Optional.ofNullable(deque.peekLeft()));
    }

    @Test
    public void testDequePeekRight(){
        assertEquals(java.util.Optional.of(1), java.util.Optional.ofNullable(deque.peekRight()));
    }
}
