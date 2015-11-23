package chap17;

import static helpers.Printer.*;

/**
 * Write a method which finds the negation of a number.
 * Write a method which finds the absolute value of a number.
 * You should not use if-else or any other comparison operator.
 */
public class Q04_2 {
    public static int abs(int n) {
        int cond = sign(n);
        return n * cond + negate(n) * flip(cond);
    }

    public static int negate(int n) {
        return (~n) + 1;
    }

    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int flip(int i) {
        return 1 ^ i;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(abs(0));
        println(abs(-1121));
        println(abs(Integer.MAX_VALUE));
        println(abs(Integer.MIN_VALUE + 1));
    }
}
