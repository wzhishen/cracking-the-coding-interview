package chap17;

import static helpers.Printer.*;

/**
 * Write a method which finds the maximum of two numbers.
 * You should not use if-else or any other comparison operator.
 *
 * SOLUTION
 * if-else can be translated to:
 * RESULT = EXPR_1 * COND + EXPR_2 * flip(COND), where value 1 (0)
 * in COND represents true (false).
 *
 * Signedness of an integer can be translated to: (n >> 31) & 1
 */
public class Q04 {
    public static int max1(int a, int b) {
        int k = sign(a - b);
        return a * k + b * flip(k);
    }

    // Returns 1 if positive, 0 otherwise
    public static int sign(int n) {
        // Check most significant bit: neg -> 1, pos -> 0
        return flip((n >> 31) & 1);
    }

    public static int flip(int i) {
        return 1 ^ i;
    }

    /*
     * Consider overflow of a - b
     */
    public static int max2(int a, int b) {
        int cond1 = sign(a) ^ sign(b);
        /*
         * If A and B have different signs, use sign of A to
         * indicate return max; otherwise fall back to original
         * max1() logic.
         */
        int cond2 = sign(a) * cond1 + sign(a - b) * flip(cond1);
        return a * cond2 + b * flip(cond2);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(max1(-1, 5) + " " + max2(-1, 5));
        println(max1(-1, -5) + " " + max2(-1, -5));
        println(max1(Integer.MAX_VALUE, Integer.MIN_VALUE) + " " + max2(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
