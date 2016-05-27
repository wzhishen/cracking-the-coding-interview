package chap07;

import static helpers.Printer.*;

/**
 * Write methods to implement the multiply, subtract, and divide
 * operations for integers. Use only the add operator.
 */
public class Q4 {
    // returns a + b
    public static int add(int a, int b) {
        if (a > 0 && b > Integer.MAX_VALUE - a)
            throw new IllegalArgumentException("Addition overflow!");
        if (a < 0 && b < Integer.MIN_VALUE - a)
            throw new IllegalArgumentException("Addition underflow!");
        return a + b;
    }

    // returns a - b
    public static int subtract(int a, int b) {
        return add(a, negate(b));
    }

    // returns -a
    public static int negate(int a) {
        int base = a > 0 ? -1 : 1;
        int result = 0;
        while (a != 0) {
            a = add(a, base);
            result = add(result, base);
        }
        return result;
    }

    // returns a * b
    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int absA = abs(a), absB = abs(b);
        if (absA < absB) return multiply(b, a);
        boolean isNegative = a > 0 != b > 0;
        int result = 0;
        for (int i = 0; i < absB; ++i) {
            result = add(result, absA);
        }
        return isNegative ? negate(result) : result;
    }

    //returns a / b
    public static int divide(int a, int b) {
        if (a == 0) return 0;
        if (b == 0) throw new IllegalArgumentException("Divisor is zero!");
        int absA = abs(a), absB = abs(b);
        boolean isNegative = a > 0 != b > 0;
        int sum = 0, result = 0;
        while (add(sum, absB) <= absA) {
            sum = add(sum, absB);
            result = add(result, 1);
        }
        return isNegative ? negate(result) : result;
    }

    // returns absolute value of a
    public static int abs(int a) {
        return a >= 0? a : negate(a);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        test(9, 3);
        test(9, 4);
        test(0, -1);
        test(-100, 999);
        test(-23456,-56781);
    }

    private static void test(int a, int b) {
        printfln("%d + %d = %d", a, b, add(a, b));
        printfln("%d - %d = %d", a, b, subtract(a, b));
        printfln("%d * %d = %d", a, b, multiply(a, b));
        printfln("%d / %d = %d", a, b, divide(a, b));
    }
}
