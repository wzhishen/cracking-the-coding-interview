package chap09;

public class Q01 {
//    A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
//    3 steps at a time. Implement a method to count how many possible ways the child
//    can run up the stairs.
    static int[] cache = new int[500];
    static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] != 0) return cache[n];
        cache[n] = countWays(n-1) + countWays(n-2) + countWays(n-3);
        return cache[n];
    }
    
    //------------------------------------
    public static void main(String[]args) {
        System.out.println(countWays(350));
    }

}
