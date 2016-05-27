package chap11;

import static helpers.Printer.*;

/**
 * Given a sorted array of n integers that has been rotated an
 * unknown number of times, write code to find an element in
 * the array. You may assume that the array was originally
 * sorted in increasing order.
 */
public class Q3 {
    public static int search(int[] a, int x) {
        if (a == null) return -1;
        return search(a, x, 0, a.length - 1);
    }

    // worst case is O(n) time, no better than a linear scan
    private static int search(int[] a, int x, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (a[mid] == x) return mid;
        // left half is sorted
        if (a[low] < a[mid]) {
            if (x >= a[low] && x < a[mid]) {
                return search(a, x, low, mid - 1);
            } else {
                return search(a, x, mid + 1, high);
            }
        // right half sorted
        } else if (a[low] > a[mid]) {
            if (x > a[mid] && x <= a[high]) {
                return search(a, x, mid + 1, high);
            } else {
                return search(a, x, low, mid - 1);
            }
        } else {
            // left half must be all repeats
            if (a[mid] != a[high]) {
                return search(a, x, mid + 1, high);
            // no special pattern is found, so brute force
            } else {
                int result = search(a, x, low, mid - 1);
                if (result == -1)
                    result = search(a, x, mid + 1,high);
                return result;
            }
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(search(new int[] {2,2,2,2,3,4,1}, 1));
        println(search(new int[] {1,1,1,1,1,1,1,0,1,1,1,1}, 0));
        println(search(new int[] {1,1,1,2,1,1,1,1,1,1,1,1}, 2));
    }
}
