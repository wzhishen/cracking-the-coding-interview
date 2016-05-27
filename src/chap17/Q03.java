package chap17;

import static helpers.Printer.*;

/**
 * Write an algorithm which computes the number of trailing
 * zeros in n factorial.
 *
 * SOLUTION
 * Simply count the number of 5 factors.
 * A 10 factor results in a trailing 0. 10 = 2*5, and there
 * are always more 2s than 5s. So counting 5s is sufficient.
 */
public class Q03 {
    public static int countFactZeros(int n) {
        if (n < 0) return -1;
        int cnt = 0;
        for (int i = 5; i <= n; i += 5) {
            cnt += countFiveFactors(i);
        }
        return cnt;
    }

    private static int countFiveFactors(int n) {
        int cnt = 0;
        while (n % 5 == 0) {
            ++cnt;
            n /= 5;
        }
        return cnt;
    }

    public static int countFactZeros2(int n) {
        if (n < 0) return -1;
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(countFactZeros(5) + " " + countFactZeros2(5));
        println(countFactZeros(260) + " " + countFactZeros2(260));
        println(countFactZeros(1808548329) + " " + countFactZeros2(1808548329));
    }
}
