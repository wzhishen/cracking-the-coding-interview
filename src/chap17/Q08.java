package chap17;

import static helpers.Printer.*;

/**
 * You are given an array of integers (both positive and negative).
 * Find the contiguous sequence with the largest sum. Return the sum.
 *
 * EXAMPLE
 * Input: [2, -8, 3, -2, 4, -10]
 * Outputs: [3, -2, 4]
 */
public class Q08 {
    // returns [startIndex, endIndex, maxSum]
    public static int[] getMaxSumSequence(int[] a) {
        if (a == null || a.length == 0) return null;

        int start = 0, end = 0, sum = 0;
        int[] ret = {0, 0, Integer.MIN_VALUE};
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
            end = i;
            if (sum > ret[2]) {
                ret[0] = start;
                ret[1] = end;
                ret[2] = sum;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return ret;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        test(new int[] {2, -10});
        test(new int[] {2, -10, 50});
        test(new int[] {2, -8, 3, 5, 1, -2, 4, -10});
        test(new int[] {-8, -2, -10});
    }

    private static void test(int[] a) {
        int[] ret = getMaxSumSequence(a);
        println(ret[0] + " " + ret[1] + " " + ret[2]);
    }
}
