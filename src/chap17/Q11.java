package chap17;

import static helpers.Printer.*;

import java.util.Random;

/**
 * Implement a method rand7() given rand5() That is, given a method
 * that generates a random number between 0 and 4 (inclusive), write
 * a method that generates a random number between 0 and 6 (inclusive).
 */
public class Q11 {
    private static Random r = new Random();

    public static int rand7() {
        while(true) {
            int n = 5 * rand5() + rand5();
            if (n < 21) return n % 7;
        }
    }

    public static int rand5() {
        return r.nextInt(5);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        final int N = 10;
        for (int i = 0; i < N; ++i)
            print(rand7() + " ");
    }
}
