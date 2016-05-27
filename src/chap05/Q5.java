package chap05;

import static helpers.Printer.*;
import static helpers.Bit.*;

/**
 * Write a function to determine the number of bits required to
 * convert integer A to integer B.
 *
 * EXAMPLE
 * Input:  31, 14 (11111, 01110)
 * Output: 2
 */
public class Q5 {
    public static int bitsFlipRequired(int a, int b) {
        int cnt = 0;
        int diff = a ^ b;
        for (int i = diff; i > 0; i &= i - 1) ++cnt;
        return cnt;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int a = 101, b = 140;
        println(toBitString(a) + " " + toBitString(b));
        println("bitsFlipRequired: " + bitsFlipRequired(a, b));
    }
}
