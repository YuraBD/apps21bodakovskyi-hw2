package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.Queue;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList<Integer> im;

    @Before
    public void setUp() {
        im = new ImmutableArrayList<>(new Integer[]{1,2,3,4,5});
    }

    @Test
    public void testAddTest() {
        String expected = "[1, 2, 3, 4, 5, 10]";
        im = im.add(10);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddWithIndex() {
        String expected = "[1, 0, 2, 3, 4, 5]";
        im = im.add(1, 0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithWrongIndex() {
        im.add(100, 0);

    }

    @Test
    public void testAddAll() {
        String expected = "[1, 2, 3, 4, 5, 1, 2, 3]";
        im = im.addAll(new Integer[]{1,2,3});
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test
    public void testAddAllWithIndex() {
        String expected = "[1, 2, 1, 2, 3, 3, 4, 5]";
        im = im.addAll(2, new Integer[]{1,2,3});
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithWrongIndex() {
        im.addAll(100, new Integer[]{1,2,3});
    }

    @Test
    public void testGet() {
        Integer expected = 1;
        Integer actualResult = im.get(0);

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithWrongIndex() {
        im.get(100);
    }

    @Test
    public void testRemove() {
        String expected = "[1, 2, 3, 5]";
        im = im.remove(3);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithWrongIndex() {
        im.remove(100);

    }

    @Test
    public void testSet() {
        String expected = "[1, 2, 3, 4, 0]";
        im = im.set(4, 0);
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithWrongIndex() {
        im.set(1000, 0);
    }

    @Test
    public void testIndexOfWithExistingElement() {
        int expected = 1;
        int actualResult = im.indexOf(2);

        assertEquals(expected, actualResult);
    }

    @Test
    public void testIndexOfWithoutElement() {
        int expected = -1;
        int actualResult = im.indexOf(10);

        assertEquals(expected, actualResult);
    }

    @Test
    public void testIndexOfForNull() {
        im = im.add(null);
        int expected = 5;
        int actualResult = im.indexOf(null);

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
    public void testIsEmpty() {
        boolean actualResult = im.isEmpty();
        assertFalse(actualResult);
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
    public void testToString() {
        String expected = "[1, 2, 3, 4, 5]";
        String actualResult = im.toString();

        assertEquals(expected, actualResult);
    }

}
