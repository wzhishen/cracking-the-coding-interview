package chap05;

public class Q7 {
//    An array A contains all the integers from 0 to n, except for one number which is
//    missing. In this problem, we cannot access an entire integer in A with a single
//    operation. The elements of A are represented in binary, and the only operation
//    we can use to access them is "fetch the jth bit of A[i]," which takes constant
//    time. Write code to find the missing integer. Can you do it in 0(n) time?
    
    int findMissingInt(int[] a, int n) {
        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            int base = 1;
            int num = 0;
            for (int j = 0; j <= length(a[i]); ++j) {
                num += fetch(a, i, j) * base;
                base *= 2;
            }
            sum += num;
        }
        return sum - (0 + n)*n/2;
    }
    
    private int fetch(int[] a, int i, int j) {
        /* fetch the jth bit of A[i]
         * Not implemented
         */
        return 0;
    }
    
    private int length(int bin) {
        /* get length of binary
         * Not implemented
         */
        return 0;
    }

}
