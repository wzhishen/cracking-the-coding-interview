package chap17;

import static helpers.Printer.*;

/**
 * Write a function to swap a number in place (that is, without
 * temporary variables).
 */
public class Q01 {
    public static int[] swap(int a, int b) {
        a = a - b; // diff = a - b
        b = b + a; // now b is b + diff, which is a
        a = b - a; // now a is a - diff, which is b
        return new int[] {a, b};
    }

    /*
     * Fact:
     * if diff = a XOR b, then
     * b is a XOR diff,
     * a is b XOR diff.
     */
    public static int[] swap2(int a, int b) {
        a = a ^ b; // diff = a XOR b
        b = b ^ a; // now b is b XOR diff, which is a
        a = b ^ a; // now a is a XOR diff, which is b
        return new int[] {a, b};
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int a = 10, b = 55;
        printfln("a: %d, b: %d", a, b);
        int[] result = swap(a, b);
        printfln("a: %d, b: %d", result[0], result[1]);
        result = swap2(a, b);
        printfln("a: %d, b: %d", result[0], result[1]);
    }
}
