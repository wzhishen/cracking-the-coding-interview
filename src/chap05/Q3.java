package chap05;

public class Q3 {
//    Given a positive integer, print the next smallest and the next largest number that
//    have the same number of 1 bits in their binary representation.
    
    static int getNext(int n) {
        assert n > 0;
        int numOnes = countNumOnes(n);
        for (int i = n+1; i < Integer.MAX_VALUE;++i) {
            if (countNumOnes(i) == numOnes)
                return i;
        }
        return -1;
    }
    
    static int getPrev(int n) {
        assert n > 0;
        int numOnes = countNumOnes(n);
        for (int i = n-1; i > 0; --i) {
            if (countNumOnes(i) == numOnes)
                return i;
        }
        return -1;
    }
    
    private static int countNumOnes(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) ++cnt;
            n /= 2;
        }
        return cnt;
    }
    
    //--------------------------------------------------
    public static void main(String[]args) {
        System.out.println(getNext(5)+" "+getPrev(5));
    }

}
