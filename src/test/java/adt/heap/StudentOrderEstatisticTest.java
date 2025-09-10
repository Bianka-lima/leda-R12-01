package adt.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsHeapImpl;

public class StudentOrderEstatisticTest {

    // instância da implementação
    private OrderStatistics<Integer> order = new OrderStatisticsHeapImpl<>();

    @Test
    public void testOrderStatisticsBasic() {
        Integer[] array = {4, 2, 7, 1};

        assertEquals(Integer.valueOf(1), order.getOrderStatistics(array, 1));
        assertEquals(Integer.valueOf(2), order.getOrderStatistics(array, 2));
        assertEquals(Integer.valueOf(4), order.getOrderStatistics(array, 3));
        assertEquals(Integer.valueOf(7), order.getOrderStatistics(array, 4));
    }
    @Test
    public void testEmptyArray() {
        Integer[] array = {};
        assertNull(order.getOrderStatistics(array, 1));
    }

    @Test
    public void testSingleElement() {
        Integer[] array = {42};
        assertEquals(Integer.valueOf(42), order.getOrderStatistics(array, 1));
        assertNull(order.getOrderStatistics(array, 2));
    }

    @Test
    public void testInvalidK() {
        Integer[] array = {1, 2, 3};
        assertNull(order.getOrderStatistics(array, 0));
        assertNull(order.getOrderStatistics(array, -1));
        assertNull(order.getOrderStatistics(array, 4));
    }

    @Test
    public void testAlreadySortedAscending() {
        Integer[] array = {1, 2, 3, 4, 5};
        assertEquals(Integer.valueOf(3), order.getOrderStatistics(array, 3));
    }

    @Test
    public void testAlreadySortedDescending() {
        Integer[] array = {9, 8, 7, 6};
        assertEquals(Integer.valueOf(7), order.getOrderStatistics(array, 2));
    }

    @Test
    public void testWithDuplicates() {
        Integer[] array = {5, 1, 5, 3, 5};
        assertEquals(Integer.valueOf(5), order.getOrderStatistics(array, 3));
    }

    @Test
    public void testAllEqual() {
        Integer[] array = {7, 7, 7, 7};
        assertEquals(Integer.valueOf(7), order.getOrderStatistics(array, 1));
        assertEquals(Integer.valueOf(7), order.getOrderStatistics(array, 4));
    }

    @Test
    public void testNegativeAndPositive() {
        Integer[] array = {-3, -1, 2, 4};
        assertEquals(Integer.valueOf(-3), order.getOrderStatistics(array, 1));
        assertEquals(Integer.valueOf(-1), order.getOrderStatistics(array, 2));
        assertEquals(Integer.valueOf(2), order.getOrderStatistics(array, 3));
        assertEquals(Integer.valueOf(4), order.getOrderStatistics(array, 4));
    }

    @Test
    public void testWithExtremes() {
        Integer[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        assertEquals(Integer.valueOf(Integer.MIN_VALUE), order.getOrderStatistics(array, 1));
        assertEquals(Integer.valueOf(0), order.getOrderStatistics(array, 2));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), order.getOrderStatistics(array, 3));
    }
}
