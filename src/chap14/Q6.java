package chap14;

import static helpers.Printer.*;

import java.util.Iterator;

/**
 * Implement a Circular Array class that supports an array-like
 * data structure which can be efficiently rotated. The class
 * should use a generic type, and should support iteration via
 * the standard for (Obj o : circuLarArray) notation.
 */
public class Q6 {
    public static class CircularArray<T> implements Iterable<T> {
        private T[] array;
        private int head;
        public CircularArray(int size) {
            array = (T[]) new Object[size];
            head = 0;
        }
        /* n > 0: rotate left; n < 0: rotate right */
        public void rotate(int n) {
            head = shift(n);
        }
        public T get(int index) {
            if (index < 0 || index >= array.length)
                throw new IllegalArgumentException("Invalid index!");
            return array[shift(index)];
        }
        public void set(int index, T value) {
            if (index < 0 || index >= array.length)
                throw new IllegalArgumentException("Invalid index!");
            array[shift(index)] = value;
        }
        private int shift(int index) {
            int i = (head + index) % array.length;
            if (i < 0) i += array.length;
            return i;
        }
        @Override
        public Iterator<T> iterator() {
            return new CircularArrayIterator<T>();
        }

        public class CircularArrayIterator<I> implements Iterator<I> {
            private int current = 0;
            @Override
            public boolean hasNext() {
                return current <= array.length - 1;
            }
            @Override
            public I next() {
                return (I) get(current++);
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }
    

    //TEST----------------------------------
    public static void main(String[] args) {
        CircularArray<Integer> array = new CircularArray<Integer>(8);
        array.set(0, 10);
        array.set(1, 20);
        array.set(3, 40);
        printCircularArray(array);
        array.rotate(1);
        printCircularArray(array);
        array.rotate(-202);
        printCircularArray(array);
    }

    private static void printCircularArray(CircularArray<Integer> array) {
        for (Integer n : array) {
            print(n + " ");
        }
        println();
    }
}
