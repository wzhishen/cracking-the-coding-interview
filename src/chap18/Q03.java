package chap18;

import static helpers.Printer.*;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a method to randomly generates set of m integers from
 * an array of size n. Each element must have equal probability
 * of being chosen.
 */
public class Q03 {
    public static int[] randomize(int[] a, int m) {
        if (a == null || m < 0) return null;
        if (m >= a.length) m = a.length;
        int[] result = Arrays.copyOfRange(a, 0, m);
        for (int i = m; i < a.length; ++i) {
            int r = rand(0, i);
            if (r < m) result[r] = a[i];
        }
        return result;
    }

    private static int rand(int start, int end) {
        Random r = new Random();
        return r.nextInt(end - start + 1) + start;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray(randomize(a, 3));
        printArray(randomize(a, 8));
        printArray(randomize(a, 50));
    }
}
