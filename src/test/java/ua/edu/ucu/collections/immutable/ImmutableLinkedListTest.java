package ua.edu.ucu.collections.immutable;

import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList<Integer> im;

    @Before
    public void setUp() {
        im = new ImmutableLinkedList<>(new Integer[]{1,2,3,4,5});
    }

    @Test
    public void testAdd() {
        String expected = "[1, 2, 3, 4, 5, 10]";
        im = im.add(10);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddWithEmptyList() {
        im = im.clear();
        String expected = "[1]";
        im = im.add(1);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddWithIndexOfFirstElement() {
        String expected = "[0, 1, 2, 3, 4, 5]";
        im = im.add(0, 0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void TestAddWithIndexWithWrongIndex() {
        im = im.add(1000, 1000);
    }

    @Test
    public void testWithIndex() {
        String expected = "[1, 2, 0, 3, 4, 5]";
        im = im.add(2, 0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddAll() {
        String expected = "[1, 2, 3, 4, 5, 1, 2, 3]";
        im = im.addAll(new Integer[]{1,2,3});
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddAllWithEmptyList() {
        im = im.clear();
        String expected = "[1, 2, 3]";
        im = im.addAll(new Integer[]{1,2,3});
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddAllWithIndexOfFirstElement() {
        String expected = "[1, 2, 3, 1, 2, 3, 4, 5]";
        im = im.addAll(0, new Integer[]{1,2,3});
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithWrongIndex () {
        im.addAll(1000, new Integer[]{1,2,3});
    }

    @Test
    public void testGet() {
        Integer expected = 1;
        Integer actualResult = im.get(0);

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithWrongIndex() {
        im.get(1000);
    }

    @Test
    public void testRemoveWithIndexOfFirstElement() {
        String expected = "[2, 3, 4, 5]";
        im = im.remove(0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testRemoveWithOneElementList() {
        im = new ImmutableLinkedList<>(new Integer[]{1});
        String expected = "[]";
        im = im.remove(0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithEmptyList() {
        im = im.clear();
        im.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithWrongIndex() {
        im.remove(1000);
    }

    @Test
    public void testRemove() {
        String expected = "[1, 2, 4, 5]";
        im = im.remove(2);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithWrongIndex() {
        im.set(1000, 10);
    }

    @Test
    public void testSet() {
        String expected = "[1, 0, 3, 4, 5]";
        im = im.set(1, 0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithEmptyList() {
        im = im.clear();
        im.set(0, 100);
    }

    @Test
    public void testIndexOfWithExistingElement() {
        int expected = 0;
        int actualResult = im.indexOf(1);

        assertEquals(expected, actualResult);
    }

    @Test
    public void testIndexOfWithoutElement() {
        int expected = -1;
        int actualResult = im.indexOf(10);

        assertEquals(expected, actualResult);
    }

    @Test
    public void testIndexOfWithEmptySet() {
        im = im.clear();
        int expected = -1;
        int actualResult = im.indexOf(2);

        assertEquals(expected, actualResult);
    }

    @Test
    public void testSize() {
        int expected = 5;
        int actualResult = im.size();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testClear() {
        String expected = "[]";
        im = im.clear();
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testToObjectArray() {
        Object[] expected = new Object[]{1,2,3,4,5};
        Object[] actual = im.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToTypeArrayWithBiggerLength() {
        Integer[] expected = new Integer[]{1,2,3,4,5,null,null};
        Integer[] actualResult = new Integer[7];
        actualResult = im.toArray(actualResult);

        assertArrayEquals(expected, actualResult);
    }

    @Test
    public void testToTypeArrayWithSmallerLength() {
        Integer[] expected = new Integer[]{1,2,3,4,5};
        Integer[] actualResult = new Integer[2];
        actualResult = im.toArray(actualResult);

        assertArrayEquals(expected, actualResult);
    }

    @Test
    public void testToTypeArrayWithEqualLength() {
        Integer[] expected = new Integer[]{1,2,3,4,5};
        Integer[] actualResult = new Integer[5];
        actualResult = im.toArray(actualResult);

        assertArrayEquals(expected, actualResult);
    }

    @Test
    public void testAddFirst() {
        String expected = "[0, 1, 2, 3, 4, 5]";
        im = im.addFirst(0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddFirstWithEmptyList() {
        im = im.clear();
        String expected = "[1]";
        im = im.add(1);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddLast() {
        String expected = "[1, 2, 3, 4, 5, 10]";
        im = im.addLast(10);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddLastWithEmptyList() {
        im = im.clear();
        String expected = "[1]";
        im = im.add(1);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testGetHead() {
        Integer expected = 1;
        Integer actualResult = im.getHead().getValue();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testGetTail() {
        Integer expected = 5;
        Integer actualResult = im.getTail().getValue();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testGetFist() {
        Integer expected = 1;
        Integer actualResult = im.getFirst();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testGetNullFirst() {
        im = im.clear();
        Integer expected = null;
        Integer actualResult = im.getFirst();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testGetLast() {
        Integer expected = 5;
        Integer actualResult = im.getLast();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testGetNullLast() {
        im = im.clear();
        Integer expected = null;
        Integer actualResult = im.getLast();

        assertEquals(expected, actualResult);
    }

    @Test
    public void removeFirst() {
        String expected = "[2, 3, 4, 5]";
        im = im.removeFirst();
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstWithEmptyList() {
        im = im.clear();
        im.removeFirst();
    }

    @Test
    public void testRemoveLast() {
        String expected = "[1, 2, 3, 4]";
        im = im.removeLast();
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastWithEmptyList() {
        im = im.clear();
        im.removeFirst();
    }

    @Test
    public void testToString() {
        String expected = "[1, 2, 3, 4, 5]";
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(im.isEmpty());
        im = im.clear();
        assertTrue(im.isEmpty());
    }
}
