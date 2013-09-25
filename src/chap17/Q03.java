package chap17;

public class Q03 {
//    Write an algorithm which computes the number of trailing zeros in n factorial
//    
//    SOLUTION: Simply count the number of 5 factors.
//              A 10 factor results in a trailing 0. 10=2*5, and there are always 
//              more 2s than 5s. So counting 5s is sufficient.
    
    static int cntFactZeros(int n) {
        if (n < 0) return -1;
        int cnt = 0;
        for (int i = 5; i <= n; ++i)
            cnt += cntFactorFive(i);
        return cnt;
    }
    
    private static int cntFactorFive(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 5 == 0) ++cnt;
            n /= 5;
        }
        return cnt;
    }
    
    //------------------------------------------
    public static void main(String[]args) {
        System.out.println(cntFactZeros(5));
        System.out.println(cntFactZeros(10));
        System.out.println(cntFactZeros(15));
    }

}
