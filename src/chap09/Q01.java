package chap09;

import static helpers.Printer.*;

/**
 * A child is running up a staircase with n steps, and can
 * hop either 1 step, 2 steps, or 3 steps at a time. Implement
 * a method to count how many possible ways the child can run
 * up the stairs.
 */
public class Q01 {
    public static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static int countWaysDP(int n) {
        return countWaysDP(n, new int[n + 1]);
    }

    private static int countWaysDP(int n, int[] cache) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] == 0)
            cache[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        return cache[n];
    }

    public static void countWaysPrinter(int n) {
        println(n + "-step stairs:");
        if (n <= 0) {
            println("None!");
        } else {
            println("countWays:   " + countWays(n));
            println("countWaysDP: " + countWaysDP(n));
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
