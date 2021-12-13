package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{1,2,3,4};
//        ImmutableList<Integer> im = new ImmutableArrayList<>();
//        arr[1] = 0;
//        System.out.println(im);
//        System.out.println(im.add(10));
//        System.out.println(im.add(1, 100));
//        System.out.println(im.addAll(new Integer[]{0, 0, 0}));
//        System.out.println(im.addAll(2, new Integer[]{0, 0, 0}));
//        System.out.println(im.get(3));
//        System.out.println(im.remove(1));
//        System.out.println(im.set(1, 100));
//        System.out.println(im.indexOf(3));
//        System.out.println(im.size());
//        System.out.println(im.clear());
//        System.out.println(im.isEmpty());
//        System.out.println(im.clear().isEmpty());
//        im = im.add(10);
//        Integer[] arr1 = new Integer[im.size()];
//        im.toArray(arr1);
//        System.out.println(Arrays.toString(arr1));


//        Integer[] arr = new Integer[]{1,2,3,4};
//        ImmutableLinkedList<Integer> im = new ImmutableLinkedList<>(arr);
//        System.out.println(im);
//        System.out.println(im.addLast(2));
//        System.out.println(im.addLast(2).add(2).add(3));
//        System.out.println(im.addFirst(1).addFirst(3).addLast(1000));
//        System.out.println(im.add( 1, 0));
//        System.out.println(im.addAll(new Integer[]{100, 200, 300}));
//        System.out.println(im.addAll(3, new Integer[]{100, 200, 300}));
//        System.out.println(im.indexOf(4));
//        Integer[] a = new Integer[10];
//        a[9] = 0;
//        a[8] = 100;
//        im.toArray(a);s
//        System.out.println(Arrays.toString(a));


//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        ImmutableArrayList<Integer> im = new ImmutableArrayList<>(new Integer[]{1,2,3,4,5});
//        Integer[] expected = new Integer[]{1,2,3,4,5};
//        Integer[] actualResult = new Integer[2];
//        actualResult =  im.toArray(actualResult);
//        System.out.println(Arrays.deepToString(actualResult));
        ImmutableLinkedList<Integer> im = new ImmutableLinkedList<>(new Integer[]{1,2,3,4,5});
        Integer[] expected = new Integer[]{1,2,3,4,5};
        Integer[] actualResult = new Integer[2];
        actualResult = im.toArray(actualResult);
        System.out.println(actualResult);
    }
}
