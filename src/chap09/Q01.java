package chap09;

import static helpers.Printer.*;

/**
 * A child is running up a staircase with n steps, and can
 * hop either 1 step, 2 steps, or 3 steps at a time. Implement
 * a method to count how many possible ways the child can run
 * up the stairs.
 */
public class Q01 {
    // Naive: O(3^n) time, O(n) space
    public static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    // Memoization (top-down): O(n) time, O(n) space
    public static int countWaysMemo(int n) {
        return countWaysMemo(n, new int[n + 1]);
    }

    private static int countWaysMemo(int n, int[] cache) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] == 0)
            cache[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        return cache[n];
    }

    // DP with rolling array (bottom-up): O(n) time, O(1) space
    public static int countWaysDP(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;

        int[] dp = new int[3];
        dp[0] = 1; dp[1] = 2; dp[2] = 4;
        for (int i = 3; i < n; ++i) {
            dp[i%3] = dp[(i - 1)%3] + dp[(i - 2)%3] + dp[(i - 3)%3];
        }
        return dp[(n - 1)%3];
    }

    public static void countWaysPrinter(int n) {
        println(n + "-step stairs:");
        if (n <= 0) {
            println("None!");
        } else {
            println("countWays:     " + countWays(n));
            println("countWaysMemo: " + countWaysMemo(n));
            println("countWaysDP:   " + countWaysDP(n));
        }
        println();
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        countWaysPrinter(1);
        countWaysPrinter(10);
        countWaysPrinter(25);
    }
}
