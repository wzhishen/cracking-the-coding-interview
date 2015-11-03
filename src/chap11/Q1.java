package chap11;

import static helpers.Printer.*;

/**
 * You are given two sorted arrays, A and B, where A has a large
 * enough buffer at the end to hold B. Write a method to merge B
 * into A in sorted order.
 */
public class Q1 {
    public static void merge(int[] a, int[] b, int lastA) {
        if (a == null || b == null) return;
        int indexA = lastA + b.length;
        int lastB = b.length - 1;
        while (lastA >= 0 && lastB >= 0) {
            if (a[lastA] >= b[lastB]) {
                a[indexA] = a[lastA];
                --lastA;
            } else {
                a[indexA] = b[lastB];
                --lastB;
            }
            --indexA;
        }
        while (lastB >= 0) {
            a[indexA] = b[lastB];
            --indexA;
            --lastB;
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] a = {1,3,4,5,6,0,0,0,0,0,0,0,0,0,0};
        int[] b = {2,3,3,7};
        merge(a, b, 4);
        printArray(a);
    }
}
