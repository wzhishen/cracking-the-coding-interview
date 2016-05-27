package chap09;

import static helpers.Printer.*;

import java.util.ArrayList;

/**
 * A magic index in an array A[0...n] is defined to be an index
 * such that A[i] = i. Given a sorted array of distinct integers,
 * write a method to find a magic index, if one exists, in array A.
 *
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class Q03 {
    // O(log n) time
    public static int getMagicIndex(int[] a) {
        if (a == null) return -1;
        return getMagicIndex(a, 0, a.length - 1);
    }

    private static int getMagicIndex(int[] a, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (a[mid] == mid) {
            return mid;
        }
        else if (a[mid] < mid) {
            return getMagicIndex(a, mid + 1, end);
        }
        else {
            return getMagicIndex(a, start, mid - 1);
        }
    }

    // worst case O(n) time, no better than a linear scan
    public static int getMagicIndexDup(int[] a) {
        if (a == null) return -1;
        return getMagicIndexDup(a, 0, a.length - 1);
    }

    private static int getMagicIndexDup(int[] a, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (a[mid] == mid) return mid;
        // search left
        int result = getMagicIndexDup(a, start, Math.min(mid - 1, a[mid]));
        // search right
        if (result == -1) {
            result = getMagicIndexDup(a, Math.max(mid + 1, a[mid]), end);
        }
        return result;
    }

    /**
     * FOLLOW UP 2
     * What if multiple indexes are satisfied?
     * Find all indexes.
     */

    // worst case O(n) time, no better than a linear scan
    public static ArrayList<Integer> getAllMagicIndexDup(int[] a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        getAllMagicIndexDup(a, 0, a.length - 1, result);
        return result;
    }

    private static void getAllMagicIndexDup(int[] a, int start, int end, ArrayList<Integer> result) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        if (a[mid] == mid) result.add(mid);
        // search left
        getAllMagicIndexDup(a, start, Math.min(mid - 1, a[mid]), result);
        // search right
        getAllMagicIndexDup(a, Math.max(mid + 1, a[mid]), end, result);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(getMagicIndex(new int[] {-1, 0, 1, 3, 5, 7, 9}));
        println(getMagicIndexDup(new int[] {-1,0,2,2,2,2,3,4,6,9,11,12,13}));
        println(getMagicIndexDup(new int[] {-10,-5,2,2,2,3,4,7,9,12,13}));
        println(getAllMagicIndexDup(new int[] {-10,-5,2,2,2,3,4,7,9,12,13}));
    }
}
