package chap18;

import static helpers.Printer.*;

import java.util.Random;

/**
 * Write a method to shuffle a deck of cards. It must be a perfect
 * shuffle -- in other words, each of the 52! permutations of the
 * deck has to be equally likely. Assume that you are given a random
 * number generator which is perfect.
 */
public class Q02 {
    /*
     * SOLUTION
     * Move through the array and, for each element i, swap array[i]
     * with a random element between 0 and i, inclusive.
     */
    public static void shuffle(int[] a) {
        if (a == null) return;
        for (int i = 0; i < a.length; ++i) {
            int r = rand(0, i);
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    private static int rand(int start, int end) {
        Random r = new Random();
        return r.nextInt(end - start + 1) + start;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        final int N = 5;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < N; ++i) {
            shuffle(a);
            printArray(a);
        }
    }
}
