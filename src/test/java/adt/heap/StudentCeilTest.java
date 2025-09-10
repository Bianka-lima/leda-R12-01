package adt.heap;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;
import adt.heap.extended.FloorCeilHeap;
import adt.heap.extended.FloorCeilHeapImpl;

public class StudentCeilTest {

    private FloorCeilHeap floorCeil =
        new FloorCeilHeapImpl(Comparator.naturalOrder());

    @Test
    public void testBasicCases() {
        Integer[] array = {4, 2, 7, 1};
        assertEquals(Integer.valueOf(7), floorCeil.ceil(array, 5));  // 7 é o menor >= 5
        assertEquals(Integer.valueOf(4), floorCeil.ceil(array, 3));  // 4 é o menor >= 3
        assertEquals(Integer.valueOf(7), floorCeil.ceil(array, 7));  // igual ao número
        assertEquals(Integer.valueOf(1), floorCeil.ceil(array, 0));  // menor >= 0
    }

    @Test
    public void testNoCeil() {
        Integer[] array = {1, 2, 3};
        assertNull(floorCeil.ceil(array, 5)); // nenhum número >= 5
    }

    @Test
    public void testEmptyArray() {
        Integer[] array = {};
        assertNull(floorCeil.ceil(array, 10));
    }

    @Test
    public void testSingleElement() {
        Integer[] array = {42};
        assertEquals(Integer.valueOf(42), floorCeil.ceil(array, 40));
        assertEquals(Integer.valueOf(42), floorCeil.ceil(array, 42));
        assertNull(floorCeil.ceil(array, 50));
    }

    @Test
    public void testWithDuplicates() {
        Integer[] array = {2, 2, 2, 10};
        assertEquals(Integer.valueOf(2), floorCeil.ceil(array, 1));
        assertEquals(Integer.valueOf(10), floorCeil.ceil(array, 9));
    }

    @Test
    public void testNegativeAndPositive() {
        Integer[] array = {-10, -5, 0, 5, 10};
        assertEquals(Integer.valueOf(-5), floorCeil.ceil(array, -6));
        assertEquals(Integer.valueOf(0), floorCeil.ceil(array, -1));
        assertEquals(Integer.valueOf(10), floorCeil.ceil(array, 9));
    }

    @Test
    public void testWithExtremes() {
        Integer[] array = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        assertEquals(Integer.valueOf(0), floorCeil.ceil(array, -1000000));
        assertEquals(Integer.valueOf(0), floorCeil.ceil(array, -1));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), floorCeil.ceil(array, Integer.MAX_VALUE));
    }
}

