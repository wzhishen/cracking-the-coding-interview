package chap17;

import static helpers.Printer.*;

/**
 * Given an array of integers, write a method to find indices m
 * and n such that if you sorted elements m through n, the entire
 * array would be sorted. Minimize n - m.
 *
 * EXAMPLE
 * Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 * Output: (3, 9)
 */
public class Q06 {
    /*
     * If sorted, this relation should hold:
     * last(left_part)   <= min(middle_part)
     * first(right_part) >= max(middle_part)
     */
    public static int[] findUnsortedPart(int[] a) {
        if (a == null) return null;
        int left = 0;
        while (left <= a.length - 2 && a[left] <= a[left + 1]) ++left;
        int right = a.length - 1;
        while (right >= 1 && a[right] >= a[right - 1]) --right;
        if (left >= right) return new int[] {-1, -1};
        int midMin = Integer.MAX_VALUE, midMax = Integer.MIN_VALUE;
        for (int i = left; i <= right; ++i) {
            if (a[i] > midMax) midMax = a[i];
            if (a[i] < midMin) midMin = a[i];
        }
        while (left >= 0 && a[left] > midMin) --left;
        while (right <= a.length - 1 && a[right] < midMax) ++right;
        return new int[] {left + 1, right - 1};
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        test(new int[] {-1, -2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        test(new int[] {-1, -2, 4, 7, 7, 10, 11, 7, 12, 12, 12, 16, 18, 19});
        test(new int[] {1, 7, 7, 7, 12, 12, 12, 16});
        test(new int[] {6, 5, 4, 3, -2, -1});
    }

    private static void test(int[] a) {
        int[] result = findUnsortedPart(a);
        println(result[0] + " " + result[1]);
    }
}
