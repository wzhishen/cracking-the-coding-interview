package chap18;

public class Q04 {
//    Write a method to count the number of 2s that appear in all the numbers
//    between 0 and n (inclusive).
//    EXAMPLE
//    Input: 25
//    Output: 9 (2,12,20,21,22,23, 24 and 25. Note that 22 counts for two 2s.)
    
    // brute force
    int countTwosInRange(int n) {
        int cnt = 0;
        for (int i = 2; i <= n; ++i) {
            cnt += countTwos(i);
        }
        return cnt;
    }
    
    private int countTwos(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 10 == 2) {
                ++cnt;
            }
            n /= 10;
        }
        return cnt;
    }

}
