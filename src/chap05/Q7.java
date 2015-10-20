package chap05;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * An array A contains all the integers from 0 to n, except for
 * one number which is missing. In this problem, we cannot access
 * an entire integer in A with a single operation. The elements
 * of A are represented in binary, and the only operation we can
 * use to access them is "fetch the j-th bit of A[i]," which takes
 * constant time. Write code to find the missing integer. Can you
 * do it in 0(n) time?
 */
public class Q7 {
    /* SOLUTION
     * 1. Start with the first least significant bit (LSB(0)).
     * 2. Count occurrences of 1's vs 0's.
     * 3. If count(1) < count(0), then the missing number has a 1 as its LSB,
     *    else it has a 0.
     * 4. Only retain all numbers with LSB matching result found in step 3.
     * 5. Repeat steps 1-4, iterating from least significant bit (LSB(0))
     *    -> 2nd least significant bit (LSB(1)) -> ...
     *    -> most significant bit (LSB(N))
     */
    public static int findMissingInteger(ArrayList<Integer> a) {
        int j = 0;
        int n = 0;
        while (a.size() > 0) {
            int bit = findMissingIntegerBit(a, j);
            n |= bit << j;
            a = filter(a, j, bit);
            ++j;
        }
        return n;
    }

    private static int findMissingIntegerBit(ArrayList<Integer> a, int j) {
        int numOnes = 0;
        int numZeros = 0;
        for (int i = 0; i < a.size(); ++i) {
            int bit = fetch(a, i, j);
            if (bit == 1) ++numOnes;
            else ++numZeros;
        }
        if (numOnes < numZeros) return 1;
        else return 0;
    }

    private static ArrayList<Integer> filter(ArrayList<Integer> a, int j, int bit) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); ++i) {
            if (fetch(a, i, j) == bit)
                result.add(a.get(i));
        }
        return result;
    }

    private static int fetch(ArrayList<Integer> a, int i, int j) {
        int n = a.get(i);
        return (n >> j) & 1;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Integer[] a = {0,1,2,3,5,6,7,8,9,10};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(a));
        Collections.shuffle(list);
        println(findMissingInteger(list));
    }
}
