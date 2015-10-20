package chap05;

import static helpers.Printer.*;
import static helpers.Bit.*;

/**
 * Given a positive integer, print the next smallest and the next
 * largest number that have the same number of 1 bits in their
 * binary representation.
 */
public class Q3 {
    public static int getNext(int n) {
        assert n > 0;
        int numOnes = countNumOnes(n);
        for (int i = n + 1; i <= Integer.MAX_VALUE; ++i) {
            if (countNumOnes(i) == numOnes)
                return i;
        }
        return -1;
    }

    public static int getPrev(int n) {
        assert n > 0;
        int numOnes = countNumOnes(n);
        for (int i = n - 1; i > 0; --i) {
            if (countNumOnes(i) == numOnes)
                return i;
        }
        return -1;
    }

    private static int countNumOnes(int n) {
        int cnt = 0;
        for (int i = n; i > 0; i &= (i - 1)) {
            ++cnt;
        }
        return cnt;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        test(5);
        test(50);
    }

    private static void test(int n) {
        println(n + " (" + toBitString(n) + ")");
        int next = getNext(n), prev = getPrev(n);
        println("next: " + next + " ("+ toBitString(next) + ")");
        println("prev: " + prev + " ("+ toBitString(prev) + ")");
        println();
    }
}
