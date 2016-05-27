package chap05;

import static helpers.Printer.*;
import static helpers.Bit.*;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions,
 * i and j. Write a method to insert M into N such that M starts at
 * bit j and ends at bit i. You can assume that the bits j through i
 * have enough space to fit all of M. That is, if M = 10011, you can
 * assume that there are at least 5 bits between j and i. You would
 * not, for example, have j = 3 and i = 2, because M could not fully
 * fit between bit 3 and bit 2.
 *
 * EXAMPLE
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 *
 * Key:
 * First create mask 11110000011 on N, then place M into N.
 */
public class Q1 {
    public static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        // clear bit & set bit
        return (n & mask) | (m << i);
    }

    public static int updateBits2(int n, int m, int i, int j) {
        int mask = ~((1 << (j+1)) - (1 << i));
        return (n & mask) | (m << i);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int n = toInt("1010011011"), m = toInt("11010");
        int i = 2, j = 6;
        println(toBitString(updateBits(n, m, i, j)));
        println(toBitString(updateBits2(n, m, i, j)));
    }
}
