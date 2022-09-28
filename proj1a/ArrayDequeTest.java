import org.junit.Test;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void createOne() {
        ArrayDeque<Integer> bd = new ArrayDeque<> ();
        int[] array = {0,1,2,3,4,5,6,7,8};
        for (int i : array) {
            bd.addLast(i);
        }
        bd.printDeque();
        System.out.println(bd.size);
        System.out.println(bd.length);
    }

    @Test
    public void addAndRemove() {
        ArrayDeque<Integer> bd = new ArrayDeque<> ();
        bd.addLast(0);
        bd.addLast(1);
        bd.addFirst(2);
        bd.addLast(3);
        bd.addLast(4);
        bd.addLast(5);
        bd.addFirst(6);
        assertEquals(bd.get(1), 2, 0.000001);
        bd.addLast(8);
        bd.addLast(9);
        bd.addLast(10);
        bd.addFirst(11);
        bd.addLast(12);
        assertEquals(bd.get(3), 0, 0.000001);
        assertEquals(bd.removeLast(), 12,0.000001);
        assertEquals(bd.removeFirst(), 11,0.000001);
    }





}
