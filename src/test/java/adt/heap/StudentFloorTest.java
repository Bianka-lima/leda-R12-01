package adt.heap;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import adt.heap.extended.FloorCeilHeap;
import adt.heap.extended.FloorCeilHeapImpl;

public class StudentFloorTest {

    private FloorCeilHeap floorCeil =
        new FloorCeilHeapImpl(Comparator.naturalOrder());

    @Test
    public void testBasicCases() {
        Integer[] array = {4, 2, 7, 1};
        assertEquals(Integer.valueOf(4), floorCeil.floor(array, 5));  // 4 é o maior <= 5
        assertEquals(Integer.valueOf(2), floorCeil.floor(array, 3));  // 2 é o maior <= 3
        assertEquals(Integer.valueOf(7), floorCeil.floor(array, 7));  // 7 igual ao número
        assertEquals(Integer.valueOf(1), floorCeil.floor(array, 1));  // limite inferior
    }

    @Test
    public void testNoFloor() {
        Integer[] array = {5, 6, 7};
        assertNull(floorCeil.floor(array, 4)); // nenhum número <= 4
    }

    @Test
    public void testEmptyArray() {
        Integer[] array = {};
        assertNull(floorCeil.floor(array, 10));
    }

    @Test
    public void testSingleElement() {
        Integer[] array = {42};
        assertEquals(Integer.valueOf(42), floorCeil.floor(array, 50));
        assertEquals(Integer.valueOf(42), floorCeil.floor(array, 42));
        assertNull(floorCeil.floor(array, 10));
    }

    @Test
    public void testWithDuplicates() {
        Integer[] array = {5, 5, 5, 10};
        assertEquals(Integer.valueOf(5), floorCeil.floor(array, 7));
    }

    @Test
    public void testNegativeAndPositive() {
        Integer[] array = {-10, -5, 0, 5, 10};
        assertEquals(Integer.valueOf(-5), floorCeil.floor(array, -3));
        assertEquals(Integer.valueOf(0), floorCeil.floor(array, 1));
        assertEquals(Integer.valueOf(10), floorCeil.floor(array, 15));
    }

    @Test
    public void testWithExtremes() {
        Integer[] array = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        assertEquals(Integer.valueOf(Integer.MIN_VALUE), floorCeil.floor(array, -100));
        assertEquals(Integer.valueOf(0), floorCeil.floor(array, 100));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), floorCeil.floor(array, Integer.MAX_VALUE));
    }
}

