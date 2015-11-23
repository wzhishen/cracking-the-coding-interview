package chap18;

import static helpers.Printer.*;

/**
 * Write a method to count the number of 2s that appear in all
 * the numbers between 0 and n (inclusive).
 *
 * EXAMPLE
 * Input: 25
 * Output: 9 (2, 12, 20, 21, 22, 23, 24 and 25. Note that 22
 * counts for two 2s.)
 */
public class Q04 {
    // Count 2s digit by digit
    public static int countTwos(int n) {
        if (n < 0) return -1;
        int cnt = 0;
        int len = String.valueOf(n).length();
        for (int i = 0; i < len; ++i) {
            cnt += countTwosAtDigit(n, i);
        }
        return cnt;
    }

    private static int countTwosAtDigit(int n, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = 10 * powerOf10;
        int roundDown = n - n % nextPowerOf10;
        int roundUp = roundDown + nextPowerOf10;
        int digit = (n / powerOf10) % 10;
        if (digit < 2) {
            return roundDown / 10;
        } else if (digit > 2) {
            return roundUp / 10;
        } else {
            return roundDown / 10 + n % powerOf10 + 1;
        }
    }

    // Brute force
    public static int countTwosBF(int n) {
        if (n < 0) return -1;
        int cnt = 0;
        for (int i = 0; i <= n; ++i) {
            cnt += countTwosInNumber(i);
        }
        return cnt;
    }

    private static int countTwosInNumber(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 10 == 2) ++cnt;
            n /= 10;
        }
        return cnt;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        test(22);
        test(678487);
    }

    private static void test(int n) {
        printfln("Count 2s for %d", n);
        printfln("countTwos:   %d", countTwos(n));
        printfln("countTwosBF: %d", countTwosBF(n));
        println();
    }
}
