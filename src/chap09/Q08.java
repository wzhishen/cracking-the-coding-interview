package chap09;

import static helpers.Printer.*;

/**
 * Given an infinite number of quarters (25 cents), dimes (10
 * cents), nickels (5 cents) and pennies (1 cent), write code
 * to calculate the number of ways of representing n cents.
 *
 * Good read
 * http://blog.csdn.net/fightforyourdream/article/details/16979395
 */
public class Q08 {
    /*
     * Get all combinations.
     * Pass an extra variable in each recursive call to direct
     * flow to avoid duplicate computation.
     */
    private static int makeChange(int n, int coin) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int ways = 0;
        switch(coin) {
            case 25: ways += makeChange(n - 25, 25);
            case 10: ways += makeChange(n - 10, 10);
            case 5:  ways += makeChange(n - 5, 5);
            case 1:  ways += makeChange(n - 1, 1);
        }
        return ways;
    }

    public static int makeChange(int n) {
        if (n <= 0) return 0;
        return makeChange(n, 25);
    }

    /*
     * Yet another elegant and extensible implementation with
     * same principle as above.
     * Source: http://sunmingtao.blogspot.com/2014/01/coins.html
     */
    private static final int[] COINS = {1, 5, 10, 25};
    private static int makeChange2(int n, int index) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int ways = 0;
        for (int i = 0; i <= index; ++i) {
            ways += makeChange2(n - COINS[i], i);
        }
        return ways;
    }

    public static int makeChange2(int n) {
        if (n <= 0) return 0;
        return makeChange2(n, 3);
    }

    /*
     * This implementation is WRONG because we get all permutations.
     */
    public static int makeChangeWrong(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return makeChangeWrong(n - 25) +
               makeChangeWrong(n - 10) +
               makeChangeWrong(n - 5) +
               makeChangeWrong(n - 1);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(makeChange(20));
        println(makeChange2(20));
        println(makeChangeWrong(20));
    }
}
